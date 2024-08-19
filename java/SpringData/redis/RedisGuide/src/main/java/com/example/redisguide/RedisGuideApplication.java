package com.example.redisguide;

import java.util.Collection;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
public class RedisGuideApplication {


    private static final Logger logger = LoggerFactory.getLogger(RedisGuideApplication.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
            @Qualifier("listenerAdapter") MessageListenerAdapter listenerAdapter,
            @Qualifier("listenerAdapter2") MessageListenerAdapter listenerAdapter2) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, PatternTopic.of("chat"));
        container.addMessageListener(listenerAdapter2, PatternTopic.of("party"));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver,
                "receiveMessage");
        return messageListenerAdapter;
    }

    @Bean
    MessageListenerAdapter listenerAdapter2(AnotherReceiver anotherReceiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(anotherReceiver,
                "receiveMessageToParty");
        return messageListenerAdapter;
    }


    @Bean
    Receiver receiver() {
        return new Receiver();
    }

    @Bean
    AnotherReceiver anotherReceiver() {
        return new AnotherReceiver();
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(RedisGuideApplication.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        Receiver receiver = ctx.getBean(Receiver.class);
        AnotherReceiver anotherReceiver = ctx.getBean(AnotherReceiver.class);
        while (receiver.getCount() == 0 && anotherReceiver.getCount() == 0) {
            logger.info("송신 메세지...");
            template.convertAndSend("chat", "Hello from chat!");
            template.convertAndSend("party", "Hello from party");
            template.convertAndSend("chat", "Bye from chat!");
            template.convertAndSend("party", "Bye from party");
            Thread.sleep(500L);
        }

        System.exit(0);

    }

}
