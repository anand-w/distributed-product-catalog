package com.catalog.catalogService.dto.response;

import com.catalog.catalogService.model.entity.Product;
import jakarta.annotation.Nullable;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandResponseDto implements Serializable {

  private Long id;

  private String name;

  @Nullable private List<Product> productList;
}
