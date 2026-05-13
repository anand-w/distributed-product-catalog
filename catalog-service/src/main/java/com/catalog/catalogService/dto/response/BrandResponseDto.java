package com.catalog.catalogService.dto.response;

import com.catalog.catalogService.model.entity.Product;
import jakarta.annotation.Nullable;
import java.util.List;

public class BrandResponseDto {

  private Long id;

  private String name;

  @Nullable private List<Product> productList;
}
