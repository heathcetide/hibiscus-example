package com.example.controller;

import hibiscus.cetide.app.basic.annotation.SignalHandler;
import hibiscus.cetide.app.component.signal.SignalContext;
import org.springframework.stereotype.Component;

@Component
public class HibiscusUserEventHandler {

    @SignalHandler("user:login")
    public void handleUserLogin(String id, SignalContext context) {
        // 记录登录日志
        Long userId = (Long)context.getIntermediateValue("user");
        System.out.println("receive ---- key "+id+ "    value ---- " + userId);
    }
}