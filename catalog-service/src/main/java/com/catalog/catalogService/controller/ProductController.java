package com.catalog.catalogService.controller;

import com.catalog.catalogService.model.entity.Product;
import com.catalog.catalogService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

}
