package org.ruu.proxy.app.v1;

import org.ruu.proxy.utill.ThreadUtil;

public class OrderRepositoryV1Impl implements OrderRepositoryV1{

  @Override
  public void save(String id) {
    if(id.equals("ex")) {
      throw new IllegalStateException("예외 발생!");
    }

    ThreadUtil.sleep(1000);
  }
}
