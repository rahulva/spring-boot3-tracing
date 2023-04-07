package org.example;

import io.opentracing.contrib.spring.tracer.configuration.TracerAutoConfiguration;
import org.example.tracing.ServerTracingAutoConfiguration;
//import io.opentracing.contrib.spring.web.starter.ServerTracingAutoConfiguration;
import io.opentracing.contrib.spring.web.starter.SkipPatternAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration({TracerAutoConfiguration.class, SkipPatternAutoConfiguration.class, ServerTracingAutoConfiguration.class})
public class Tire2Application {
    public static void main(String[] args) {
        System.setProperty("JAEGER_SERVICE_NAME", "product-tire2-boot3");
        SpringApplication.run(Tire2Application.class, args);
    }
}