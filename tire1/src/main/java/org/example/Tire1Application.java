package org.example;

import io.opentelemetry.instrumentation.spring.autoconfigure.EnableOpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableOpenTelemetry
public class Tire1Application {
    public static void main(String[] args) {
        SpringApplication.run(Tire1Application.class, args);
    }
}