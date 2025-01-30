package org.ruu.proxy.pureporxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

  private ConcreteLogic concreteLogic;

  public TimeProxy(ConcreteLogic concreteLogic) {
    this.concreteLogic = concreteLogic;
  }

  @Override
  public String operation() {
    long startTime = System.currentTimeMillis();
    log.info("TimeDecorator 실행");
    String result = concreteLogic.operation();
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("[실행 시간] {}", resultTime);
    return result;
  }

}
