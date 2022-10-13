package com.kudiukin.homework6.controller;

import com.kudiukin.homework6.dto.PersonDto;
import com.kudiukin.homework6.dto.ProductDto;
import com.kudiukin.homework6.service.ProductService;
import com.kudiukin.homework6.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createProductView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "createProduct";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") ProductDto productDto) throws NotFoundException {
        productService.createProduct(productDto);
        return "createProductSuccess";
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProductById(@RequestParam Long productId) throws NotFoundException {
        return productService.getProductById(productId);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestParam Long productId) throws NotFoundException {
        productService.deleteProduct(productId);
    }

//    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<ProductDto> getAll() {
//        return productService.getAllProducts();
//    }

    @GetMapping( "/all")
    public String getAllProducts(Model model) {
        model.addAttribute("all", productService.getAllProducts());
        return "allProducts";
    }
}
