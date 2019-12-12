package com.lemon.task.impl;

import com.lemon.service.ICashService;
import com.lemon.task.ITicketSuccessBackExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SuccCashExecuter implements ITicketSuccessBackExecutor {

    @Autowired
    private ICashService cashService;

    @Async
    @Override
    public void execute(String orderSn) throws Exception {
        cashService.handleSucc(orderSn);
    }
}
