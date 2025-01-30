package org.ruu.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import org.ruu.proxy.app.v1.OrderRepositoryV1;
import org.ruu.proxy.app.v1.OrderServiceV1;
import org.ruu.proxy.trace.LogTrace;
import org.ruu.proxy.trace.TraceStatus;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

  private final OrderServiceV1 orderService;
  private final LogTrace trace;

  @Override
  public void orderItem(String itemId) {
    TraceStatus status = null;
    try{
      status = trace.begin("OrderService.orderItem()");
      orderService.orderItem(itemId);
      trace.end(status);
    }catch (Exception e){
      trace.exception(status, e);
      throw e;
    }
  }
}
