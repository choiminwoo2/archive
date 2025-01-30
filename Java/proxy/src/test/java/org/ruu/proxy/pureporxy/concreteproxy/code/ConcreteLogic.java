package org.ruu.proxy.pureporxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {

  public String operation() {
    log.info("ConcretateLogic 실행");
    
    return "data";
  }
  
}
