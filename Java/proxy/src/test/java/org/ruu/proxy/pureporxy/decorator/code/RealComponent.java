package org.ruu.proxy.pureporxy.decorator.code;

import lombok.extern.slf4j.Slf4j;
import org.ruu.proxy.utill.ThreadUtil;

@Slf4j
public class RealComponent implements Component {

  @Override
  public String operation() {
    log.info("Real Component 호출");
    ThreadUtil.sleep(1000);
    return "data";
  }
}
