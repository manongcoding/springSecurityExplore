package com.mydomain.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.mydomain.event.TestEvent;

@Component
public class TestListener {
    @EventListener
    @Async
    public void test(TestEvent event) {
        System.out.println("TestListener:" + event.getMessage());
    }
}
