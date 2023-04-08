package org.example;

import io.opentracing.contrib.spring.tracer.configuration.TracerAutoConfiguration;
import io.opentracing.contrib.spring.web.starter.SkipPatternAutoConfiguration;
import org.example.tracing.EnableServletTracing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ImportAutoConfiguration({TracerAutoConfiguration.class, SkipPatternAutoConfiguration.class, org.example.tracing.ServerTracingAutoConfiguration.class})
@EnableServletTracing
public class Tire1Application {
    public static void main(String[] args) {
        SpringApplication.run(Tire1Application.class, args);
    }
}