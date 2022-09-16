package com.kudiukin.homework3.service;

import com.kudiukin.homework3.model.Person;
import com.kudiukin.homework3.model.Product;
import com.kudiukin.homework3.utils.exception.NotFoundException;

import java.util.Collection;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Integer productId) throws NotFoundException;

    Product updateProduct(Integer productId, Product product) throws NotFoundException;

    void deleteProduct(Integer productId) throws NotFoundException;

    Collection<Product> getAllProducts();

}