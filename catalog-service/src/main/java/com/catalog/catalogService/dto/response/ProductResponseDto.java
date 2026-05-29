package com.catalog.catalogService.dto.response;

import com.catalog.catalogService.model.enums.ProductStatus;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto implements Serializable {

  private Long id;

  private String sku;

  private String title;

  private String description;

  private String category;

  private BigDecimal price;

  private String currency;

  private BrandResponseDto brand;

  @Enumerated(EnumType.STRING)
  private ProductStatus status;
}
