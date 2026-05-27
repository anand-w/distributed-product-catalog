package com.catalog.catalogService.repository.specification;

import com.catalog.catalogService.dto.request.ProductFilterRequestDTO;
import com.catalog.catalogService.model.entity.Product;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
  public static Specification<Product> filterProduct(ProductFilterRequestDTO request) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (request.getId() != null) {
        predicates.add(cb.equal(root.get("Id"), request.getId()));
      } else if (request.getStatus() != null) {
        predicates.add(cb.equal(root.get("status"), request.getStatus()));
      } else if (request.getMinPrice() != null) {
        predicates.add(cb.greaterThanOrEqualTo(root.get("price"), request.getMinPrice()));
      } else if (request.getMaxPrice() != null) {
        predicates.add(cb.lessThanOrEqualTo(root.get("price"), request.getMaxPrice()));
      }

      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
