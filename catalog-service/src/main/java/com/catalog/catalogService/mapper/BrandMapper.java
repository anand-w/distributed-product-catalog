package com.catalog.catalogService.mapper;

import com.catalog.catalogService.dto.response.BrandResponseDto;
import com.catalog.catalogService.model.entity.Brand;

public class BrandMapper {
  public static BrandResponseDto toResponseDto(Brand brand) {

    return BrandResponseDto.builder().id(brand.getId()).name(brand.getName()).build();
  }
}
