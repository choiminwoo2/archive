package org.ruu.advanced.app.v2;


import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.TraceIdV1;

import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.helloTrace.HelloTraceV2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

  private final OrderRepositoryV2 orderRepository;
  private final HelloTraceV2 trace;


  public void orderItem( TraceIdV1 traceId, String itemId) {
    TraceStatusV1 status = null;
    //예외가 터져서 밑의 endr가 동작하지 않아 try, catch가 필요함
    try {
      status = trace.beginSync(traceId,"OrderServiceV2.request()");
      orderRepository.save(status.getTraceId() ,itemId);
      trace.end(status);
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
