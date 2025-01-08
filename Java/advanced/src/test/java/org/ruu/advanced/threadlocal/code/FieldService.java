package org.ruu.advanced.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import org.ruu.advanced.utill.ThreadUtil;
import org.springframework.stereotype.Component;

@Slf4j
public class FieldService {

  private String nameStore;

  public String logic(String name) {
    log.info("저장 name={} -> nameStore ->{}", name, nameStore);
    nameStore = name;
    ThreadUtil.sleep(1000);
    log.info("조회 nameStore={}", nameStore);
    return nameStore;
  }
}
