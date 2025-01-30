package org.ruu.proxy.config.v1_proxy.concrete_proxy;

import org.ruu.proxy.app.v2.OrderControllerV2;
import org.ruu.proxy.trace.LogTrace;
import org.ruu.proxy.trace.TraceStatus;

/**
 * 스프링 부트 3.0 이후
 * jakarta 서블릿 기반으로 바뀌게 되면서
 * 컨트롤러의 상속 부분이 불가능함.
 * @Controller 어노테이션이 무조건 필요함.
 * @RequestBody어노테이션 만으로는 컨트롤러 추가가 불가능해짐.
 */
public class OrderControllerConcreteProxy extends OrderControllerV2 {

  private final OrderControllerV2 target;
  private final LogTrace trace;

  public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace trace) {
    super(null);
    this.target = target;
    this.trace = trace;
  }

//  @Override
//  public String request(String itemId) {
//    TraceStatus status = null;
//    try{
//      status = trace.begin("OrderRepository.request()");
//      String result = target.request(itemId);
//      trace.end(status);
//      return result;
//    }catch (Exception e){
//      trace.exception(status, e);
//      throw e;
//    }
//  }
//
//  @Override
//  public String noLog() {
//    return target.noLog();
//  }

}
