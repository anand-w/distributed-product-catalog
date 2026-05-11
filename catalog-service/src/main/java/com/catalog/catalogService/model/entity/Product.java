package com.catalog.catalogService.model.entity;

import com.catalog.catalogService.model.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String title;

    private String description;

    private String brand;

    private String category;

    private BigDecimal price;

    private String currency;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
}