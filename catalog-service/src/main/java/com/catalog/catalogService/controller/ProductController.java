package com.catalog.catalogService.controller;

import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import com.catalog.catalogService.model.entity.Product;
import com.catalog.catalogService.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/id/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long productId){

        ProductResponseDto responseDto=productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody @Valid ProductRequestDto product){

        return ResponseEntity.ok().body(productService.save(product));

    }

}
