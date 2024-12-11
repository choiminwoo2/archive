package com.example.redisguide;

import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherReceiver {

    private static final Logger logger = LoggerFactory.getLogger(AnotherReceiver.class);

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessageToParty(String message) {
        logger.info("수신 party: <" + message + ">");
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
