package com.ecommerce.product.adapter.out;

import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.infrastructure.persistence.IProductRepository;
import com.ecommerce.product.infrastructure.persistence.SpringJpaProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepository implements IProductRepository {

    private final SpringJpaProductRepository repository;

    public ProductRepository(SpringJpaProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product request) {
        repository.save(request);
    }

    @Override
    public Product deleteById(UUID id) {
        return null;
    }
}
