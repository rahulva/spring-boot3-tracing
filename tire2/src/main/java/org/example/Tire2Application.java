package org.example;

import io.opentelemetry.instrumentation.spring.autoconfigure.EnableOpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableServletTracing*/
@EnableOpenTelemetry
public class Tire2Application {
    public static void main(String[] args) {
        SpringApplication.run(Tire2Application.class, args);
    }
}