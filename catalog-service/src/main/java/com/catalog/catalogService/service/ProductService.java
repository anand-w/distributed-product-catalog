package com.catalog.catalogService.service;

import com.catalog.catalogService.dto.request.ProductFilterRequestDTO;
import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  public ProductResponseDto save(ProductRequestDto product);

  public Page<ProductResponseDto> getAll(ProductFilterRequestDTO productFilter, Pageable pageable);

  public ProductResponseDto getProductById(Long id);
}
