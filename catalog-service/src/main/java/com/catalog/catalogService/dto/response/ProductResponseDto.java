package com.catalog.catalogService.dto.response;

import com.catalog.catalogService.model.entity.Brand;
import com.catalog.catalogService.model.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {

    private Long id;

    private String sku;

    private String title;

    private String description;

    private String category;

    private BigDecimal price;

    private String currency;

    private Brand brand;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
}
