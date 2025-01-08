package org.ruu.advanced.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import org.ruu.advanced.utill.ThreadUtil;

@Slf4j
public class ThreadLocalService {

  private ThreadLocal<String> nameStore = new ThreadLocal<>();

  public String logic(String name) {
    log.info("저장 name={} -> nameStore ->{}", name, nameStore.get());
    nameStore.set(name);
    ThreadUtil.sleep(1000);
    log.info("조회 nameStore={}", nameStore.get());
    return nameStore.get();
  }
}
