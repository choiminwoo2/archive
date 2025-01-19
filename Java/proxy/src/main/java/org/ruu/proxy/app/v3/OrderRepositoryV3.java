package org.ruu.proxy.app.v3;

import org.ruu.proxy.utill.ThreadUtil;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV3 {

  public void save(String id) {
    if(id.equals("ex")) {
      throw new IllegalStateException("예외 발생!");
    }

    ThreadUtil.sleep(1000);
  }
}
