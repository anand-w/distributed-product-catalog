package com.catalog.catalogService.dto.request;

import com.catalog.catalogService.model.enums.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

  @NotBlank(message = "Product sku is required")
  private String sku;

  @NotBlank(message = "Product title is required")
  private String title;

  private String description;

  @NotBlank(message = "Product category is required")
  private String category;

  @NotNull(message = "Product price is required")
  private BigDecimal price;

  private String currency;

  @NotNull(message = "Please provide brandID")
  private Long brandId;

  @Enumerated(EnumType.STRING)
  private ProductStatus status;
}
