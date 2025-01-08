package org.ruu.advanced.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ruu.advanced.threadlocal.code.FieldService;
import org.ruu.advanced.threadlocal.code.ThreadLocalService;
import org.ruu.advanced.utill.ThreadUtil;

@Slf4j
public class ThreadLocalServiceTest {

  private ThreadLocalService fieldService = new ThreadLocalService();

  @Test
  void field() {
    log.info("main start");
    Runnable userA = () -> fieldService.logic("userA");
    Runnable userB = () -> fieldService.logic("userB");
    Thread threadA = new Thread(userA);
    threadA.setName("threadA");
    Thread threadB = new Thread(userB);
    threadB.setName("threadB");

    threadA.start();
    ThreadUtil.sleep(100);
    threadB.start();
    ThreadUtil.sleep(3000);
  }
}
