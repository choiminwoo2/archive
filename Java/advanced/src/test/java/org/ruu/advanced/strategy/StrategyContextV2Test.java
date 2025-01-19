package org.ruu.advanced.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ruu.advanced.strategy.code.ContextV1;
import org.ruu.advanced.strategy.code.ContextV2;
import org.ruu.advanced.strategy.code.Strategy;
import org.ruu.advanced.strategy.code.StrategyLogic1;
import org.ruu.advanced.strategy.code.StrategyLogic2;
import org.ruu.advanced.template.code.AbstractTemplate;
import org.ruu.advanced.template.code.SubClassLogic1;
import org.ruu.advanced.template.code.SubClassLogic2;

@Slf4j
public class StrategyContextV2Test {

  @Test
  void strategtyV1() {
    ContextV2 context = new ContextV2();
    context.execute(new StrategyLogic1());
    context.execute(new StrategyLogic2());

  }


}
