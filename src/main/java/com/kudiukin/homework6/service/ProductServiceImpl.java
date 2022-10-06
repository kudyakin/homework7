package com.kudiukin.homework6.service;

import com.kudiukin.homework6.dto.ProductDto;
import com.kudiukin.homework6.model.Product;
import com.kudiukin.homework6.repository.ProductRepository;
import com.kudiukin.homework6.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.kudiukin.homework6.converter.ProductConverter.getProductDtoFromProduct;
import static com.kudiukin.homework6.converter.ShopConverter.getShopFromShopDto;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ShopService shopService;

    public ProductServiceImpl(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws NotFoundException {
        Product product = new Product(productDto.getName(), productDto.getPrice());
        product.setShop(getShopFromShopDto(shopService.getShopById(productDto.getShopId())));
        shopService.getShopById(productDto.getShopId()).getProducts().add(product);
        productRepository.save(product);
        return getProductDtoFromProduct(product);
    }

    @Override
    public ProductDto getProductById(Long productId) throws NotFoundException {
        if (productRepository.findById(productId).isPresent()) {
            return getProductDtoFromProduct(productRepository.findById(productId).get());
        } else {
            throw new NotFoundException("Product with ID #" + productId + " is not found");
        }
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productRepository.findById(productDto.getProductId())
                .map(entity -> {
                    entity.setName(productDto.getName());
                    entity.setPrice(productDto.getPrice());
                    try {
                        entity.setShop(getShopFromShopDto(shopService.getShopById(productDto.getShopId())));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    return getProductDtoFromProduct(productRepository.save(entity));
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + productDto.getProductId()));
    }

    @Override
    public void deleteProduct(Long productId) throws NotFoundException {
        if (productRepository.existsById(productId)) {
            shopService.getShopById((productRepository.findById(productId).get()).getShop().getId()).getProducts().remove(getProductById(productId));
            productRepository.deleteById(productId);
        } else {
            throw new NotFoundException("Product with ID #" + productId + " is not found");
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepository.findAll().forEach(product -> productDtoList.add(getProductDtoFromProduct(product)));
        return productDtoList;
    }
}
