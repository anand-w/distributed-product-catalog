package com.catalog.catalogService.service;

import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import com.catalog.catalogService.exception.BrandNotFoundException;
import com.catalog.catalogService.exception.ProductNotFoundException;
import com.catalog.catalogService.mapper.ProductMapper;
import com.catalog.catalogService.model.entity.Brand;
import com.catalog.catalogService.model.entity.Product;
import com.catalog.catalogService.repository.BrandRepository;
import com.catalog.catalogService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  @Autowired private BrandRepository brandRepository;

  @Override
  public ProductResponseDto save(ProductRequestDto productRequestDto) {

    Brand brand =
        brandRepository
            .findById(productRequestDto.getBrandId())
            .orElseThrow(
                () ->
                    new BrandNotFoundException(
                        "Brand with id " + productRequestDto.getBrandId() + " does not exist"));

    Product product = ProductMapper.toEntity(productRequestDto, brand);
    Product savedProduct = productRepository.save(product);

    return ProductMapper.toResponseDto(savedProduct);
  }

  public Page<ProductResponseDto> getAll(Pageable pageable) {
    Page<Product> productsList = productRepository.findAll(pageable);
    return productsList.map(ProductMapper::toResponseDto);
  }

  @Override
  public ProductResponseDto getProductById(Long id) {

    Product product =
        productRepository
            .findById(id)
            .orElseThrow(
                () -> new ProductNotFoundException("Product with id " + id + " does not exist"));

    return ProductMapper.toResponseDto(product);
  }
}
