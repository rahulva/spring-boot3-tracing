/**
 * Copyright 2018-2019 The OpenTracing Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.example.tracing;

import io.opentracing.Tracer;
import io.opentracing.contrib.spring.tracer.configuration.TracerAutoConfiguration;
import io.opentracing.util.GlobalTracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Pavol Loffay
 */
@Configuration
//@ConditionalOnBean(Tracer.class)
//@AutoConfigureAfter(ServerTracingAutoConfiguration.class)
@Slf4j
public class ServletTracerRegisterAutoConfiguration {

  @Autowired
  private Tracer tracer;

  @PostConstruct
  public void registerToGlobalTracer() {
    log.info("Registering global tracer {}", tracer);
    /**
     * Tracer registered in GlobalTracer should be the same as the tracer bean.
     * There can be {@link org.springframework.beans.factory.config.BeanPostProcessor}'s which
     * alters tracer bean, therefore tracer registered to GlobalTracer should be autowired.
     */
    GlobalTracer.registerIfAbsent(tracer);
  }
}
