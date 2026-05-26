package com.catalog.catalogService.controller;

import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import com.catalog.catalogService.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

  @Autowired private ProductService productService;

  @GetMapping
  public ResponseEntity<Page<ProductResponseDto>> getAllProducts(Pageable pageable) {

    return ResponseEntity.ok(productService.getAll(pageable));
  }

  @GetMapping("/id/{productId}")
  public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long productId) {

    ProductResponseDto responseDto = productService.getProductById(productId);
    return ResponseEntity.ok(responseDto);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ResponseEntity<ProductResponseDto> create(@RequestBody @Valid ProductRequestDto product) {

    return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
  }
}
