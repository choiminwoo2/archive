package org.ruu.proxy.jdkdynamic.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AImpl implements AInterface{

  private static final Logger log = LoggerFactory.getLogger(AImpl.class);

  @Override
  public String call() {
    log.info("A 호출");
    return "A";
  }
}
