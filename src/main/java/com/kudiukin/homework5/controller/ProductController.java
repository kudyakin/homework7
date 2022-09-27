package com.kudiukin.homework5.controller;

import com.kudiukin.homework5.dto.ProductDto;
import com.kudiukin.homework5.dto.ProductUpdateDto;
import com.kudiukin.homework5.model.Product;
import com.kudiukin.homework5.service.ProductService;
import com.kudiukin.homework5.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@RequestBody ProductDto dto) throws NotFoundException {
        return productService.createProduct(dto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@RequestParam Long productId) throws NotFoundException {
        return productService.getProductById(productId);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestBody ProductUpdateDto dto) {
        return productService.updateProduct(dto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long deleteProduct(@RequestParam Long productId) throws NotFoundException {
        productService.deleteProduct(productId);
        return productId;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
}
