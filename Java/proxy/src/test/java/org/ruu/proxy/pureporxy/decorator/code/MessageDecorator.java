package org.ruu.proxy.pureporxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{

  private Component component;

  public MessageDecorator(Component component) {
    this.component = component;
  }

  @Override
  public String operation() {
    log.info("MessageDecorator operation 실행");
    String result = component.operation();
    String decoResult = "****" + result + "****";
    log.info("Message 꾸미기 전={}, 꾸민 후={}", result, decoResult);
    return decoResult;
  }
}
