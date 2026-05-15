package com.catalog.catalogService.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brands")
@Builder
public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  @Builder.Default
  private List<Product> products = new ArrayList<>();
}
