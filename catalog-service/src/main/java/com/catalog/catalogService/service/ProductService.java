package com.catalog.catalogService.service;

import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import com.catalog.catalogService.model.entity.Product;

import java.util.List;

public interface ProductService {

    public ProductResponseDto save(ProductRequestDto product);

    public List<Product> getAll();

    public ProductResponseDto getProductById(Long id);
}
