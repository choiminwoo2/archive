package org.ruu.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import org.ruu.advanced.app.trace.template.AbstractTemplate;
import org.ruu.advanced.callback.TraceTemplate;
import org.ruu.advanced.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

  private final OrderServiceV5 orderService;
  private final TraceTemplate template;

  public OrderControllerV5(OrderServiceV5 orderService, LogTrace logTrace) {
    this.orderService = orderService;
    this.template = new TraceTemplate(logTrace);
  }


  @GetMapping("/v5/request")
  public String request(String itemId) {
    return template.execute("OrderController.request()", () -> {
      orderService.orderItem(itemId);
      return "ok";
    });
  }
}
