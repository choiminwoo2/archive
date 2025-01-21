package org.ruu.proxy.pureporxy.decorator;

import org.junit.jupiter.api.Test;
import org.ruu.proxy.pureporxy.decorator.code.Component;
import org.ruu.proxy.pureporxy.decorator.code.DecoratorPatternClient;
import org.ruu.proxy.pureporxy.decorator.code.MessageDecorator;
import org.ruu.proxy.pureporxy.decorator.code.RealComponent;
import org.ruu.proxy.pureporxy.decorator.code.TimeDecorator;

public class DecoratorTest {

  @Test
  void noDecoratorTest() {
    Component realComponent = new RealComponent();
    DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
    client.execute();
  }

  @Test
  void decorator1(){
    Component realComponent = new RealComponent();
    Component messageDecorator = new MessageDecorator(realComponent);
    DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
    client.execute();
  }

  @Test
  void decorator2() {
    Component realComponent = new RealComponent();
    Component messageDecorator = new MessageDecorator(realComponent);
    Component timeDecorator = new TimeDecorator(messageDecorator);
    DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
    client.execute();
  }
}
