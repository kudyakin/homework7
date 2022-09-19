package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Product;
import com.kudiukin.homework4.utils.exception.NotFoundException;

import java.util.Collection;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Integer productId) throws NotFoundException;

    Product updateProduct(Integer productId, Product product) throws NotFoundException;

    void deleteProduct(Integer productId) throws NotFoundException;

    Collection<Product> getAllProducts();

}