package org.ruu.advanced.app.v4;


import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.template.AbstractTemplate;
import org.ruu.advanced.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

  private final OrderRepositoryV4 orderRepository;
  private final LogTrace trace;


  public void orderItem(String itemId) {
    AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
      @Override
      protected Void call() {
        orderRepository.save(itemId);
        return null;
      }
    };
    template.execute("OrderServiceV4.request()");

  }
}
