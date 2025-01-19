package org.ruu.advanced.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {

  private Strategy strategy;

  public ContextV1(Strategy strategy) {
    this.strategy = strategy;
  }

  public void execute() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    strategy.call();
    //비지니스로직 종료
    long endTime = System.currentTimeMillis();
    long result = endTime - startTime;
    log.info("resultTime={}", result);
  }
}
