package com.catalog.catalogService.service;

import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import com.catalog.catalogService.exception.ProductNotFoundException;
import com.catalog.catalogService.mapper.ProductMapper;
import com.catalog.catalogService.model.entity.Brand;
import com.catalog.catalogService.model.entity.Product;
import com.catalog.catalogService.repository.BrandRepository;
import com.catalog.catalogService.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  @Autowired private BrandRepository brandRepository;

  @Override
  public ProductResponseDto save(ProductRequestDto productRequestDto) {

    Optional<Brand> brand = Optional.of(new Brand());
    brand = brandRepository.findById(productRequestDto.getBrandId());

    Product product = ProductMapper.toEntity(productRequestDto, brand.get());
    Product savedProduct = productRepository.save(product);

    return ProductMapper.toResponseDto(savedProduct);
  }

  public List<ProductResponseDto> getAll() {
    List<Product> productsList = productRepository.findAll();
    return productsList.stream().map(ProductMapper::toResponseDto).toList();
  }

  @Override
  public ProductResponseDto getProductById(Long id) {

    Optional<Product> product = productRepository.findById(id);
    if (product != null) {
      return ProductMapper.toResponseDto(product.get());
    } else {
      throw new ProductNotFoundException("Product with id " + id + " does not exist");
    }
  }
}
