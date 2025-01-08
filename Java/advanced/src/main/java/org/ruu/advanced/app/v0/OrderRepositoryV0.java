package org.ruu.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.ruu.advanced.utill.ThreadUtil;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

  public void save(String itemId) {
    //저장 로직
    if("ex".equals(itemId)) {
      throw new IllegalStateException("예외 발생");
    }
    ThreadUtil.sleep(1000);
  }
}
