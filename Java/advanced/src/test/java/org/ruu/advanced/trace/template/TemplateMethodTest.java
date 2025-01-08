package org.ruu.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ruu.advanced.trace.template.code.AbstractTemplate;
import org.ruu.advanced.trace.template.code.SubClassLogic1;
import org.ruu.advanced.trace.template.code.SubClassLogic2;

@Slf4j
public class TemplateMethodTest {

  @Test
  void templateMethodV0() {
    logic1();
    logic2();
  }

  @Test
  void logic1() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    log.info("비지니스 로직1 실행");

    long endTime = System.currentTimeMillis();
    long result = endTime - startTime;
    log.info("resultTime: {} ms", result);
  }

  @Test
  void logic2() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    log.info("비지니스 로직2 실행");

    long endTime = System.currentTimeMillis();
    long result = endTime - startTime;
    log.info("resultTime: {} ms", result);
  }

  // 템플릿 메서드 패턴 적용
  @Test
  void templateMethodV1() {
    AbstractTemplate template1 = new SubClassLogic1();
    AbstractTemplate template2 = new SubClassLogic2();
    template1.execute();
    template2.execute();
  }

  //익명 클래스 사용
  @Test
  void templateMethodV2() {
    AbstractTemplate template1 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("비지니스 로직1 실행");
      }
    };

    AbstractTemplate template2 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("비지니스 로직2 실행");
      }
    };
    log.info("클래스 이름 = {}", template1.getClass());
    template1.execute();
    log.info("클래스 이름 = {}", template2.getClass());
    template2.execute();

  }

}
