package com.example.springstart.study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class ConditionalTest {

    @Test
    void contextTest() throws Exception {
        //true
        ApplicationContextRunner contextRunner = new ApplicationContextRunner();
        contextRunner.withUserConfiguration(Config1.class)
            .run(context -> {
                Assertions.assertThat(context).hasSingleBean(MyBean.class);
                Assertions.assertThat(context).hasSingleBean(Config1.class);

            });
        //false
        new ApplicationContextRunner().
            withUserConfiguration(Config2.class)
            .run(context -> {
                Assertions.assertThat(context).doesNotHaveBean(MyBean.class);
                Assertions.assertThat(context).doesNotHaveBean(Config1.class);

            });
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanCondition.class)
    @interface BooleanConditional{
        boolean value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(TrueCondition.class)
    @interface TrueConditional {

    }


    @Configuration()
    @BooleanConditional(true)
    static class Config1 {

        @Bean
        MyBean mybean() {

            return new MyBean();
        }


    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(False.class)
    @interface FalseConditional {

    }


    @Configuration
    @BooleanConditional(false)
    static class Config2 {

        @Bean
        MyBean mybean() {

            return new MyBean();
        }
    }

    static class TrueCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

            return true;
        }
    }

    static class False implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

            return false;
        }
    }

    static class MyBean {

    }

    private static class BooleanCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

            Map<String, Object> allAnnotationAttributes = metadata.getAnnotationAttributes(BooleanConditional.class.getName());
            Boolean value = (Boolean) allAnnotationAttributes.get("value");
            return value;
        }
    }
}
