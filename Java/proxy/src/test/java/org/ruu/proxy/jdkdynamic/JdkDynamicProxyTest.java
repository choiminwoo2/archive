package org.ruu.proxy.jdkdynamic;

import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;
import org.ruu.proxy.jdkdynamic.code.AImpl;
import org.ruu.proxy.jdkdynamic.code.AInterface;
import org.ruu.proxy.jdkdynamic.code.BImpl;
import org.ruu.proxy.jdkdynamic.code.BInterface;
import org.ruu.proxy.jdkdynamic.code.TimeInvocationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdkDynamicProxyTest {

  private static final Logger log = LoggerFactory.getLogger(JdkDynamicProxyTest.class);

  @Test
  public void dynamicA() {
    AInterface target = new AImpl();
    TimeInvocationHandler handler =   new TimeInvocationHandler(target);

    AInterface proxy1 = (AInterface) Proxy.newProxyInstance(
      AInterface.class.getClassLoader(),
      new Class[]{AInterface.class}, handler);

    proxy1.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxy1={}", proxy1.getClass());
  }

  @Test
  public void dynamicB() {
    BInterface target = new BImpl();
    TimeInvocationHandler handler =   new TimeInvocationHandler(target);

    BInterface proxy1 = (BInterface) Proxy.newProxyInstance(
      BInterface.class.getClassLoader(),
      new Class[]{BInterface.class}, handler);

    proxy1.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxy1={}", proxy1.getClass());
  }
}
