package org.ruu.proxy.pureporxy.concreteproxy;

import org.junit.jupiter.api.Test;
import org.ruu.proxy.pureporxy.concreteproxy.code.ConcreteClient;
import org.ruu.proxy.pureporxy.concreteproxy.code.ConcreteLogic;
import org.ruu.proxy.pureporxy.concreteproxy.code.TimeProxy;

public class concreteLogicTest {

  @Test
  void noProxy() {
    ConcreteLogic concreteLogic = new ConcreteLogic();
    ConcreteClient client = new ConcreteClient(concreteLogic);
    client.execute();
  }

  @Test
  void addProxy() {
    ConcreteLogic concreteLogic = new ConcreteLogic();
    TimeProxy timeProxy = new TimeProxy(concreteLogic);
    ConcreteClient client = new ConcreteClient(timeProxy);
    client.execute();
  }
}
