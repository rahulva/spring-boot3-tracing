package org.example;

import io.opentelemetry.instrumentation.spring.autoconfigure.EnableOpenTelemetry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableOpenTelemetry
class Tire2ApplicationTest {
    @Test
    void contextLoads() {
    }

}