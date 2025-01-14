package org.ruu.advanced.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ruu.advanced.template.code.AbstractTemplate;
import org.ruu.advanced.template.code.SubClassLogic1;
import org.ruu.advanced.template.code.SubClassLogic2;

@Slf4j
public class TemplateMethodTest {

  @Test
  void templateMethodV0() {
    logic1();
    logic2();
  }

  private void logic1() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    log.info("비지니스 로직1 실행");

    //비지니스로직 종료
    long endTime = System.currentTimeMillis();
    long result = endTime - startTime;
    log.info("resultTime={}", result);
  }

  private void logic2() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    log.info("비지니스 로직2 실행");

    //비지니스로직 종료
    long endTime = System.currentTimeMillis();
    long result = endTime - startTime;
    log.info("resultTime={}", result);
  }


  @Test
  void templateMethodV1() {
    AbstractTemplate template1 = new SubClassLogic1();
    template1.execute();

    AbstractTemplate template2 = new SubClassLogic2();
    template2.execute();
  }

}
