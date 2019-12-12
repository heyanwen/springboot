package com.lemon.task.impl;

import com.lemon.service.IRedisService;
import com.lemon.task.ITicketFailBackExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class FailRedisExecuter implements ITicketFailBackExecutor {

    @Autowired
    private IRedisService redisService;

    @Async
    @Override
    public void execute(String orderSn) throws Exception {
        redisService.handleFail(orderSn);
    }
}
