package org.ruu.advanced.app.v5;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.ruu.advanced.app.trace.template.AbstractTemplate;
import org.ruu.advanced.callback.TraceTemplate;
import org.ruu.advanced.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

  private final OrderRepositoryV5 orderRepository;
  private final TraceTemplate template;

  public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
    this.orderRepository = orderRepository;
    this.template = new TraceTemplate(trace);
  }


  public void orderItem(String itemId) {

    template.execute("OrderService.orderItem()", () -> {
      orderRepository.save(itemId);
      return null;
    });

  }
}
