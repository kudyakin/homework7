package com.kudiukin.homework6.service;

import com.kudiukin.homework6.NotFoundException;
import com.kudiukin.homework6.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(String name, Double price, Long shopId) throws NotFoundException;

    Product getProductById(Long productId) throws NotFoundException;

    Product updateProduct(Product product);

    void deleteProduct(Long productId) throws NotFoundException;

    List<Product> getAllProducts();

}