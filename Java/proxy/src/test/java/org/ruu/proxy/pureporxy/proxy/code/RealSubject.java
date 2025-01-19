package org.ruu.proxy.pureporxy.proxy.code;

import lombok.extern.slf4j.Slf4j;
import org.ruu.proxy.utill.ThreadUtil;

@Slf4j
public class RealSubject implements Subject{

  @Override
  public String operation() {

    log.info("실제 객체 호출");
    ThreadUtil.sleep(1000);
    return "data";
  }
}
