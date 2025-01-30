package org.ruu.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import org.ruu.proxy.app.v1.OrderRepositoryV1;
import org.ruu.proxy.trace.LogTrace;
import org.ruu.proxy.trace.TraceStatus;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

  private final OrderRepositoryV1 orderRepositoryV1;
  private final LogTrace trace;

  @Override
  public void save(String id) {
    TraceStatus status = null;
    try{
      status = trace.begin("OrderRepository.request()");
      orderRepositoryV1.save(id);
      trace.end(status);
    }catch (Exception e){
      trace.exception(status, e);
      throw e;
    }
  }
}
