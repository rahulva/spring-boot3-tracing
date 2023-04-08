package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.exporter.jaeger.JaegerGrpcSpanExporter;
import io.opentelemetry.extension.trace.propagation.JaegerPropagator;
import io.opentelemetry.opentracingshim.OpenTracingShim;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Configuration
public class TraceConfiguration {

    @Primary
    @Bean
    public Tracer init(@Value("${spring.application.name}") String service) {
        Resource serviceNameResource = Resource.create(Attributes.of(ResourceAttributes.SERVICE_NAME, service));
        ManagedChannel jaegerChannel = ManagedChannelBuilder.forAddress("localhost", 14250)
                .usePlaintext().build();
        JaegerGrpcSpanExporter jaegerExporter = JaegerGrpcSpanExporter.builder()
                .setChannel(jaegerChannel)
                .setTimeout(1, TimeUnit.SECONDS).build();
        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(jaegerExporter))
                .setResource(Resource.getDefault().merge(serviceNameResource)).build();
        OpenTelemetrySdk openTelemetry = OpenTelemetrySdk.builder()
                .setPropagators(ContextPropagators.create(
                        TextMapPropagator.composite(
                                W3CTraceContextPropagator.getInstance(), JaegerPropagator.getInstance())))
                .setTracerProvider(tracerProvider).build();
        Runtime.getRuntime().addShutdownHook(new Thread(tracerProvider::close));
        return OpenTracingShim.createTracerShim(openTelemetry);
    }
}
