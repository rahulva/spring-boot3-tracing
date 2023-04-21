package org.example.tracing;

import io.opentracing.contrib.spring.web.starter.RestTemplateTracingAutoConfiguration;
import io.opentracing.contrib.spring.web.starter.SkipPatternAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ImportAutoConfiguration({
        //TracerAutoConfiguration.class,
        SkipPatternAutoConfiguration.class,
        org.example.tracing.ServerTracingAutoConfiguration.class,
        org.example.tracing.ServletTracerRegisterAutoConfiguration.class,
        org.example.tracing.JaegerAutoConfiguration.class,
        RestTemplateTracingAutoConfiguration.class
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableServletTracing {
}
