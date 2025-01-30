package org.ruu.proxy.config.v1_proxy.concrete_proxy;

import org.ruu.proxy.app.v2.OrderRepositoryV2;
import org.ruu.proxy.trace.LogTrace;
import org.ruu.proxy.trace.TraceStatus;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

  private final OrderRepositoryV2 target;
  private final LogTrace trace;

  public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace trace) {
    this.target = target;
    this.trace = trace;
  }

  @Override
  public void save(String id) {
    TraceStatus status = null;
    try{
      status = trace.begin("OrderRepository.request()");
      target.save(id);
      trace.end(status);
    }catch (Exception e){
      trace.exception(status, e);
      throw e;
    }
  }
}
