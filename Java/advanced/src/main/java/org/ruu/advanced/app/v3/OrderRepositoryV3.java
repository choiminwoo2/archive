package org.ruu.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.TraceIdV1;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.helloTrace.HelloTraceV2;
import org.ruu.advanced.logtrace.LogTrace;
import org.ruu.advanced.utill.ThreadUtil;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

  private final LogTrace trace;


  public void save(String itemId) {

    TraceStatusV1 status = null;
    //예외가 터져서 밑의 endr가 동작하지 않아 try, catch가 필요함
    try {
      status = trace.begin("OrderRepositoryV3.request()");
      //저장 로직
      if("ex".equals(itemId)) {
        throw new IllegalStateException("예외 발생");
      }
      ThreadUtil.sleep(1000);
      trace.end(status);

    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }

  }
}
