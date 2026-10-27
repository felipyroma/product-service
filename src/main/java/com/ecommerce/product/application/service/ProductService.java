package com.ecommerce.product.application.service;

import com.ecommerce.product.adapter.in.ProductMapper;
import com.ecommerce.product.adapter.out.ProductRepository;
import com.ecommerce.product.application.dto.ProductRequest;
import com.ecommerce.product.application.dto.ProductResponse;
import com.ecommerce.product.application.exception.ProductNotFoundException;
import com.ecommerce.product.domain.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductResponse get(UUID id) {
        if(id == null){
            throw new IllegalArgumentException("ID cannot be null!");
        }

        return repository.findById(id)
                .map(mapper::entityToResponse)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponse).toList();
    }

    public void save(ProductRequest request) {
        Product product = mapper.requestToEntity(request);
        repository.save(product);
    }
}
