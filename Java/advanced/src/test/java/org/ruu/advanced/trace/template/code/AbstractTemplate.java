package org.ruu.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

  public void execute() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    call();
    long endTime = System.currentTimeMillis();
    long result = endTime - startTime;
    log.info("resultTime: {} ms", result);
  }

  protected  abstract void call();
}
