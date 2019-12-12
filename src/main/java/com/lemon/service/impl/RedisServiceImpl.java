package com.lemon.service.impl;

import com.lemon.service.IRedisService;
import org.springframework.stereotype.Component;

@Component("redis")
public class RedisServiceImpl implements IRedisService {

    public void handleSucc(String orderSn) throws Exception{
        System.out.println("线程id="+ Thread.currentThread().getId()+orderSn+"已经写入redis");
        throw new Exception("redis exception");
    }

    public void handleFail(String orderSn) {

        System.out.println("线程id="+ Thread.currentThread().getId()+orderSn+"已经从redis删除");

    }
}
