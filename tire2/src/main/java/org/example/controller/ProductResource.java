package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductResource {

    private final ProductRepository repository;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return repository.getProduct(id);
    }

    @GetMapping("/products")
    public Collection<Product> getProducts() {
        return repository.getProducts();
    }
}
