package com.ecommerce.product.adapter.in;

import com.ecommerce.product.application.dto.ProductRequest;
import com.ecommerce.product.application.dto.ProductResponse;
import com.ecommerce.product.application.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    public final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> get(
            @PathVariable UUID id
    ) {
        Optional<ProductResponse> response = Optional.ofNullable(service.get(id));

        return response.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> responses = service.findAll();

       return responses.isEmpty()?
               ResponseEntity.noContent().build() :
               ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> post(
            @RequestBody ProductRequest request
    ){
        service.save(request);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
