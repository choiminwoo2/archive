package org.ruu.advanced.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

  //파라미터 전달 방식
  public void execute(Strategy strategy) {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    strategy.call();
    //비지니스로직 종료
    long endTime = System.currentTimeMillis();
    long result = endTime - startTime;
    log.info("resultTime={}", result);
  }
}
