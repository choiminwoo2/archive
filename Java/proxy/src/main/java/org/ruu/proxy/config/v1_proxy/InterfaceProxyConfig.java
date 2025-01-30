package org.ruu.proxy.config.v1_proxy;

import org.ruu.proxy.app.v1.OrderControllerV1;
import org.ruu.proxy.app.v1.OrderControllerV1Impl;
import org.ruu.proxy.app.v1.OrderRepositoryV1;
import org.ruu.proxy.app.v1.OrderRepositoryV1Impl;
import org.ruu.proxy.app.v1.OrderServiceV1;
import org.ruu.proxy.app.v1.OrderServiceV1Impl;
import org.ruu.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import org.ruu.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import org.ruu.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import org.ruu.proxy.trace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

  @Bean
  public OrderControllerV1 orderProxyControllerV1(LogTrace logTrace) {
    OrderControllerV1Impl controller = new OrderControllerV1Impl(orderProxyServiceV1(logTrace));
    return new OrderControllerInterfaceProxy(controller, logTrace);
  }

  @Bean
  public OrderServiceV1 orderProxyServiceV1(LogTrace logTrace) {
    OrderServiceV1Impl service = new OrderServiceV1Impl(orderProxyRepositoryV1(logTrace));
    return new OrderServiceInterfaceProxy(service, logTrace);
  }

  @Bean
  public OrderRepositoryV1 orderProxyRepositoryV1(LogTrace logTrace) {
    OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
    return new OrderRepositoryInterfaceProxy(orderRepositoryV1, logTrace);
  }
}
