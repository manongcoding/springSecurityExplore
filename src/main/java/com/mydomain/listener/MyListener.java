package com.mydomain.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.mydomain.event.MyEvent;

@Component
public class MyListener {
    @EventListener
    public void test(MyEvent e) {
        System.out.println("MyListener:" + e.getMessage());
    }
}
