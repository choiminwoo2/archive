package org.ruu.advanced.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ruu.advanced.strategy.code.template.TimeLogTemplate;

@Slf4j
public class TemplateCallbackTest {

  /**
   * 템플릿 콜백 패턴 - 익명 클래스
   */
  @Test
  void callbackV1() {
    TimeLogTemplate template = new TimeLogTemplate();
    template.execute(() -> log.info("비지니스로직 1 실행"));
    template.execute(() -> log.info("비지니스로직 2 실행"));

  }

}
