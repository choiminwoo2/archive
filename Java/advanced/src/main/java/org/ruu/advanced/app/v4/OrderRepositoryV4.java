package org.ruu.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.template.AbstractTemplate;
import org.ruu.advanced.logtrace.LogTrace;
import org.ruu.advanced.utill.ThreadUtil;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

  private final LogTrace trace;


  public void save(String itemId) {
    AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
      @Override
      protected Void call() {
        if("ex".equals(itemId)) {
          throw new IllegalStateException("예외 발생");
        }
        ThreadUtil.sleep(1000);
        return null;
      }
    };
    template.execute("OrderRepositoryV4.request()");

  }
}
