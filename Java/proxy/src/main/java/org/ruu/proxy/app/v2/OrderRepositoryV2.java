package org.ruu.proxy.app.v2;

import org.ruu.proxy.utill.ThreadUtil;

public class OrderRepositoryV2 {

  public void save(String id) {
    if(id.equals("ex")) {
      throw new IllegalStateException("예외 발생!");
    }

    ThreadUtil.sleep(1000);
  }
}
