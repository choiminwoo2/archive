package org.ruu.proxy.pureporxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{

  private Component component;

  public TimeDecorator(Component component) {
    this.component = component;
  }

  @Override
  public String operation() {
    long startTime = System.currentTimeMillis();
    log.info("TimeDecorator 실행");
    String result = component.operation();
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("[실행 시간] {}", resultTime);
    return result;
  }
}
