package com.catalog.catalogService.model.entity;

import com.catalog.catalogService.model.enums.ProductStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Table(
    name = "products",
    indexes = {@Index(name = "idx_product_category", columnList = "category")})
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

  private String category;

  private BigDecimal price;

  private String currency;

  private String imageUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @Enumerated(EnumType.STRING)
  private ProductStatus status;
}
