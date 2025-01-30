package org.ruu.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import org.ruu.proxy.app.v1.OrderControllerV1;
import org.ruu.proxy.app.v1.OrderRepositoryV1;
import org.ruu.proxy.trace.LogTrace;
import org.ruu.proxy.trace.TraceStatus;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

  private final OrderControllerV1 orderController;
  private final LogTrace trace;


  @Override
  public String request(String itemId) {
    TraceStatus status = null;
    try{
      status = trace.begin("OrderRepository.request()");
      String result = orderController.request(itemId);
      trace.end(status);
      return result;
    }catch (Exception e){
      trace.exception(status, e);
      throw e;
    }
  }

  @Override
  public String noLog() {
    return orderController.noLog();
  }
}
