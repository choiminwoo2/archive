package org.ruu.advanced.app.v3;


import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.TraceIdV1;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.helloTrace.HelloTraceV2;
import org.ruu.advanced.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

  private final OrderRepositoryV3 orderRepository;
  private final LogTrace trace;


  public void orderItem(String itemId) {
    TraceStatusV1 status = null;
    //예외가 터져서 밑의 endr가 동작하지 않아 try, catch가 필요함
    try {
      status = trace.begin("OrderServiceV3.request()");
      orderRepository.save(itemId);
      trace.end(status);
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
