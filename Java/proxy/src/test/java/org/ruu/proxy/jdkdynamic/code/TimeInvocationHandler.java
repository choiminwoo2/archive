package org.ruu.proxy.jdkdynamic.code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeInvocationHandler implements InvocationHandler {

  private static final Logger log = LoggerFactory.getLogger(TimeInvocationHandler.class);

  private final Object target;


  public TimeInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    log.info("Time Proxy 실행");
    long start = System.currentTimeMillis();

    Object result = method.invoke(target, args);

    long end = System.currentTimeMillis();
    long resultTime = end - start;
    log.info("timeProxy 종료 resultTime={}", resultTime);


    return result;
  }
}
