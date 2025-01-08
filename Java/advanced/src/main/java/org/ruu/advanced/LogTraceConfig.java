package org.ruu.advanced;

import org.ruu.advanced.logtrace.FieldLogTrace;
import org.ruu.advanced.logtrace.LogTrace;
import org.ruu.advanced.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

  @Bean
  public LogTrace logTrace() {
    return new ThreadLocalLogTrace();
  }
}
