package org.ruu.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.template.AbstractTemplate;
import org.ruu.advanced.callback.TraceTemplate;
import org.ruu.advanced.logtrace.LogTrace;
import org.ruu.advanced.utill.ThreadUtil;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

  private final TraceTemplate template;

  public OrderRepositoryV5(LogTrace trace) {
    this.template = new TraceTemplate(trace);
  }


  public void save(String itemId) {
    template.execute("OrderRepository.save()", () -> {
      if("ex".equals(itemId)) {
        throw new IllegalStateException("예외 발생");
      }
      ThreadUtil.sleep(1000);
      return null;
    });
  }
}
