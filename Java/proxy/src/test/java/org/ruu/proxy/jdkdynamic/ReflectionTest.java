package org.ruu.proxy.jdkdynamic;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionTest {

  @Test
  void reflection0() {
    Hello target = new Hello();

    //공통로직 1 시작
    log.info("start");
    String result1 = target.callA();
    log.info("result1:{}", result1);
    log.info("end");
    //공통로직 1 종료

    //공통로직 2 시작
    log.info("start");
    String result2 = target.callB();
    log.info("result1:{}", result2);
    log.info("end");
    //공통로직 2 종료
  }

  @Test
  void reflection1() throws Exception{
    Class classHello = Class.forName("org.ruu.proxy.jdkdynamic.ReflectionTest$Hello");

    Hello target = new Hello();

    Method methodCallA = classHello.getMethod("callA");
    dynamicCall(methodCallA, target);

    Method methodCallB = classHello.getMethod("callB");
    dynamicCall(methodCallB, target);
  }

  private void dynamicCall(Method method, Object target) throws Exception{
    log.info("start");
    Object result = method.invoke(target);
    log.info("result:{}", result);
    log.info("end");
  }

  @Slf4j
  static class Hello {

    public String callA() {
      log.info("callA");
      return "A";
    }

    public String callB() {
      log.info("callB");
      return "B";
    }

  }
}
