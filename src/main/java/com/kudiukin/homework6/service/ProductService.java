package com.kudiukin.homework6.service;

import com.kudiukin.homework6.dto.ProductDto;
import com.kudiukin.homework6.utils.exception.NotFoundException;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto) throws NotFoundException;

    ProductDto getProductById(Long productId) throws NotFoundException;

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(Long productId) throws NotFoundException;

    List<ProductDto> getAllProducts();

}