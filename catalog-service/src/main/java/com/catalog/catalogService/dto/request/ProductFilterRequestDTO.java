package com.catalog.catalogService.dto.request;

import com.catalog.catalogService.model.enums.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductFilterRequestDTO {

  private String id;

  private String sku;

  private String category;

  @Positive private BigDecimal minPrice;

  @Positive private BigDecimal maxPrice;

  private String currency;

  private Long brandId;

  @Enumerated(EnumType.STRING)
  private ProductStatus status;
}
