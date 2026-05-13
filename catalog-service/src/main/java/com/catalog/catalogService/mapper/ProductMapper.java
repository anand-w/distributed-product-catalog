package com.catalog.catalogService.mapper;

import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import com.catalog.catalogService.model.entity.Brand;
import com.catalog.catalogService.model.entity.Product;
import lombok.Builder;

@Builder
public class ProductMapper {

  public static Product toEntity(ProductRequestDto productRequestDto, Brand brand) {

    return Product.builder()
        .sku(productRequestDto.getSku())
        .price(productRequestDto.getPrice())
        .brand(brand)
        .category(productRequestDto.getCategory())
        .currency(productRequestDto.getCurrency())
        .description(productRequestDto.getDescription())
        .title(productRequestDto.getTitle())
        .status(productRequestDto.getStatus())
        .build();
  }

  public static ProductResponseDto toResponseDto(Product product) {

    return ProductResponseDto.builder()
        .id(product.getId())
        .brand(product.getBrand())
        .price(product.getPrice())
        .sku(product.getSku())
        .status(product.getStatus())
        .title(product.getTitle())
        .description(product.getDescription())
        .currency(product.getCurrency())
        .category(product.getCategory())
        .build();
  }
}
