package com.kudiukin.homework6.converter;

import com.kudiukin.homework6.dto.ProductDto;
import com.kudiukin.homework6.model.Product;

public final class ProductConverter {

    public static ProductDto getProductDtoFromProduct (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setShopId(product.getShop().getId());
        productDto.setProductId(product.getId());
        return productDto;
    }

    public static Product getProductFromProductDto (ProductDto productDto) {
        Product product = new Product ();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setId(productDto.getProductId());
        product.setShop(productDto.getShop());
        return product;
    }
}
