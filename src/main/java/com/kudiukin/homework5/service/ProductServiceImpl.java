package com.kudiukin.homework5.service;

import com.kudiukin.homework5.dto.ProductDto;
import com.kudiukin.homework5.dto.ProductUpdateDto;
import com.kudiukin.homework5.model.Product;
import com.kudiukin.homework5.repository.ProductRepository;
import com.kudiukin.homework5.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ShopService shopService;

    public ProductServiceImpl(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    @Override
    public Product createProduct(ProductDto dto) throws NotFoundException {
        Product product = new Product(dto.getName(), dto.getPrice());
        product.setShop(shopService.getShopById(dto.getShopId()));
        shopService.getShopById(dto.getShopId()).getProducts().add(product);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) throws NotFoundException {
        if (productRepository.findById(productId).isPresent()) {
            return productRepository.findById(productId).get();
        } else {
            throw new NotFoundException("Product with ID #" + productId + " is not found");
        }
    }

    @Override
    public Product updateProduct(ProductUpdateDto dto) {
        return productRepository.findById(dto.getProductId())
                .map(entity -> {
                    entity.setName(dto.getName());
                    entity.setPrice(dto.getPrice());
                    try {
                        entity.setShop(shopService.getShopById(dto.getShopId()));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    return productRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + dto.getProductId()));
    }

    @Override
    public Long deleteProduct(Long productId) throws NotFoundException {
        if (productRepository.existsById(productId)) {
            shopService.getShopById((productRepository.findById(productId).get()).getShop().getId()).getProducts().remove(getProductById(productId));
            productRepository.deleteById(productId);
            return productId;
        } else {
            throw new NotFoundException("Product with ID #" + productId + " is not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
