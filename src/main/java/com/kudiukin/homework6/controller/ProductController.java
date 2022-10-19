package com.kudiukin.homework6.controller;

import com.kudiukin.homework6.converter.ProductConverter;
import com.kudiukin.homework6.dto.ProductDto;
import com.kudiukin.homework6.service.ProductService;
import com.kudiukin.homework6.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static com.kudiukin.homework6.converter.ProductConverter.getProductDtoFromProduct;
import static com.kudiukin.homework6.converter.ProductConverter.getProductFromProductDto;

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
        productService.createProduct(productDto.getName(), productDto.getPrice(), productDto.getShopId());
        return "createProductSuccess";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getProductByIdView(Model model) {
        model.addAttribute("productById", new ProductDto());
        return "getProduct";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getProductById(@ModelAttribute("productById") ProductDto productDto, Model model) throws NotFoundException {
        ProductDto productById = getProductDtoFromProduct(productService.getProductById(productDto.getProductId()));
        model.addAttribute("productById", productById);
        return "getProductSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatePrdocutView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "updateProduct";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product") ProductDto productDto) {
        productService.updateProduct(getProductFromProductDto(productDto));
        return "updateProductSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProductView(Model model) {
        model.addAttribute("product", new ProductDto());
        return "deleteProduct";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteProduct(@ModelAttribute("product") ProductDto productDto) throws NotFoundException {
        productService.deleteProduct(productDto.getProductId());
        return "deleteProductSuccess";
    }

    @GetMapping( "/all")
    public String getAllProducts(Model model) {
        model.addAttribute("all", productService.getAllProducts().stream()
                .map(ProductConverter::getProductDtoFromProduct).collect(Collectors.toList()));
        return "allProducts";
    }
}
