package org.ruu.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.template.AbstractTemplate;
import org.ruu.advanced.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

  private final OrderServiceV4 orderService;
  private final LogTrace logTrace;

  @GetMapping("/v4/request")
  public String request(String itemId) {
    AbstractTemplate<String> template = new AbstractTemplate<String>(logTrace) {
      @Override
      protected String call() {
        orderService.orderItem(itemId);
        return "ok";
      }
    };
    return template.execute("OrderControllerV4.request()");
  }
}
