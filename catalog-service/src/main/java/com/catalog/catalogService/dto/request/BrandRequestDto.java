package com.catalog.catalogService.dto.request;

import jakarta.validation.constraints.NotBlank;

public class BrandRequestDto {

  @NotBlank(message = "Brand name is required")
  private String name;
}
