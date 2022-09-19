package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Product;
import com.kudiukin.homework4.repository.ProductCollection;
import com.kudiukin.homework4.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService{

    private static Integer productCount = 0;

    private final ProductCollection productCollection;

    public ProductServiceImpl(ProductCollection productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public Product createProduct(Product product) {
        product.setProductId(++productCount);
        productCollection.getProducts().put(product.getProductId(), product);
        return product;
    }

    @Override
    public Product getProductById(Integer productId) throws NotFoundException {
        if (productCollection.getProducts().containsKey(productId)) {
            return productCollection.getProducts().get(productId);
        } else {
            throw new NotFoundException("Product with ID #" + productId + " is not found");
        }
    }

    @Override
    public Product updateProduct(Integer productId, Product product) throws NotFoundException {
        if (productCollection.getProducts().containsKey(productId)) {
            Product tmp = productCollection.getProducts().get(productId);
            tmp.setName(product.getName());
            tmp.setPrice(product.getPrice());
            return tmp;
        } else {
            throw new NotFoundException("Person with ID #" + productId + " is not found");
        }
    }

    @Override
    public void deleteProduct(Integer productId) throws NotFoundException {
        if (productCollection.getProducts().containsKey(productId)) {
            productCollection.getProducts().remove(productId);
        } else {
            throw new NotFoundException("Product with ID #" + productId + " is not found");
        }
    }

    @Override
    public Collection<Product> getAllProducts() {
        return productCollection.getProducts().values();
    }
}
