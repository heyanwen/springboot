package com.lemon.service.impl;

import com.lemon.service.ICashService;
import org.springframework.stereotype.Component;

@Component("cash")
public class CashServiceImpl implements ICashService {

    public void handleSucc(String orderSn){
        System.out.println("线程id="+ Thread.currentThread().getId()+orderSn+"出票成功现金业务已处理");
    }
    public void handleFail(String orderSn) throws Exception {

        System.out.println("线程id="+ Thread.currentThread().getId()+orderSn+"出票失败现金业务已处理");
        throw new Exception("cash ex");
    }
}
