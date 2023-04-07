package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.model.Order;
import org.example.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

@RestController
@AllArgsConstructor
public class OrderResource {

    private final RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable("orderId") String orderId) {

        ResponseEntity<Collection<Product>> forEntity =
                restTemplateBuilder.build().exchange("http://localhost:8083/products", HttpMethod.GET,
                        null, new ParameterizedTypeReference<>() {
                        });
        return new Order(orderId, forEntity.getBody());
    }
}
