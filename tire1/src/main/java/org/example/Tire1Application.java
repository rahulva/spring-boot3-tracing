package org.example;

import io.opentracing.contrib.spring.tracer.configuration.TracerAutoConfiguration;
import io.opentracing.contrib.spring.web.starter.SkipPatternAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@ImportAutoConfiguration({TracerAutoConfiguration.class, SkipPatternAutoConfiguration.class, org.example.tracing.ServerTracingAutoConfiguration.class})
public class Tire1Application {
    public static void main(String[] args) {
        System.setProperty("JAEGER_SERVICE_NAME", "order-tire1-boot3");
        SpringApplication.run(Tire1Application.class, args);
    }
}