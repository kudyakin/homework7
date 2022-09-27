package com.kudiukin.homework5.service;

import com.kudiukin.homework5.dto.ProductDto;
import com.kudiukin.homework5.dto.ProductUpdateDto;
import com.kudiukin.homework5.model.Product;
import com.kudiukin.homework5.utils.exception.NotFoundException;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto dto) throws NotFoundException;

    Product getProductById(Long productId) throws NotFoundException;

    Product updateProduct(ProductUpdateDto dto);

    Long deleteProduct(Long productId) throws NotFoundException;

    List<Product> getAllProducts();

}