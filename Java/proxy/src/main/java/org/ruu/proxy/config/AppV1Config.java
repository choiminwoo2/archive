package org.ruu.proxy.config;

import org.ruu.proxy.app.v1.OrderControllerV1;
import org.ruu.proxy.app.v1.OrderControllerV1Impl;
import org.ruu.proxy.app.v1.OrderRepositoryV1;
import org.ruu.proxy.app.v1.OrderRepositoryV1Impl;
import org.ruu.proxy.app.v1.OrderServiceV1;
import org.ruu.proxy.app.v1.OrderServiceV1Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {

  @Bean
  public OrderControllerV1 orderControllerV1() {
    return new OrderControllerV1Impl(orderServiceV1());
  }

  @Bean
  public OrderServiceV1 orderServiceV1() {
    return new OrderServiceV1Impl(orderRepositoryV1());
  }

  @Bean
  public OrderRepositoryV1 orderRepositoryV1() {
    System.out.println("v1 컨트롤러 등록");
    return new OrderRepositoryV1Impl();
  }
}
