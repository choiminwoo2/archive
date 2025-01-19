package org.ruu.advanced.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ruu.advanced.strategy.code.ContextV1;
import org.ruu.advanced.strategy.code.Strategy;
import org.ruu.advanced.strategy.code.StrategyLogic1;
import org.ruu.advanced.strategy.code.StrategyLogic2;
import org.ruu.advanced.template.code.AbstractTemplate;
import org.ruu.advanced.template.code.SubClassLogic1;
import org.ruu.advanced.template.code.SubClassLogic2;

@Slf4j
public class StrategyContextV1Test {

  @Test
  void strategtyV1() {
    Strategy strategy1 = new StrategyLogic1();
    Strategy strategy2 = new StrategyLogic2();
    ContextV1  context1 = new ContextV1(strategy1);
    ContextV1  context2 = new ContextV1(strategy2);

    context1.execute();
    context2.execute();

  }




  @Test
  void templateMethodV1() {
    AbstractTemplate template1 = new SubClassLogic1();
    template1.execute();

    AbstractTemplate template2 = new SubClassLogic2();
    template2.execute();
  }

}
