package org.example.model;


import java.util.List;

public record Order(String orderId, List<Product> products) {

}
