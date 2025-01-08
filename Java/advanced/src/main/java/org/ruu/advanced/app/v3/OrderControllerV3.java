package org.ruu.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.helloTrace.HelloTraceV2;
import org.ruu.advanced.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

  private final OrderServiceV3 orderService;
  private final LogTrace logTrace;

  @GetMapping("/v3/request")
  public String request(String itemId) {
    TraceStatusV1 status = null;
    //예외가 터져서 밑의 endr가 동작하지 않아 try, catch가 필요함
    try {
      status = logTrace.begin("OrderControllerV3.request()");
      orderService.orderItem(itemId);
      logTrace.end(status);
      return "ok";
    } catch (Exception e) {
      logTrace.exception(status, e);
      throw e;
    }
  }
}
