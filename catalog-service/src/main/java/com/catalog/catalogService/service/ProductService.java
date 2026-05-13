package com.catalog.catalogService.service;

import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import java.util.List;

public interface ProductService {

  public ProductResponseDto save(ProductRequestDto product);

  public List<ProductResponseDto> getAll();

  public ProductResponseDto getProductById(Long id);
}
