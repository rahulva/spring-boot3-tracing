package org.example;

import org.example.tracing.EnableServletTracing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableServletTracing
public class Tire2Application {
    public static void main(String[] args) {
        SpringApplication.run(Tire2Application.class, args);
    }
}