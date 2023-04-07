package org.example.model;


import java.util.Collection;
import java.util.List;

public record Order(String orderId, Collection<Product> products) {

}
