package com.ecommerce.product.infrastructure.persistence;

import com.ecommerce.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringJpaProductRepository extends JpaRepository<Product, UUID> {
}
