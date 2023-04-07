package org.example.repository;

import org.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<String, Product> products = Map.of(
            "1", new Product("P1", "1"),
            "2", new Product("P2", "2"),
            "3", new Product("P3", "3"),
            "4", new Product("P3", "4"));

    public Product getProduct(String id) {
        return products.get(id);
    }

    public Collection<Product> getProducts() {
        return products.values();
    }
}
