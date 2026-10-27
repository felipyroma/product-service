package com.ecommerce.product.infrastructure.persistence;

import com.ecommerce.product.domain.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductRepository {
    public Optional<Product> findById(UUID id);
    public List<Product> findAll();
    public void save(Product productDTO);
    public Product deleteById(UUID id);
}
