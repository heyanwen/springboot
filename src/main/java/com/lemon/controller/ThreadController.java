package com.lemon.controller;

import com.lemon.thread.MyThread;
import com.lemon.util.RedisUtil;
import com.lemon.util.SpringUtil;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {

    @RequestMapping("/thread")
    public void thread() {
        for(int i=0;i<10;i++){
            MyThread myThread = new MyThread();
            myThread.start();
        }
    }

    @RequestMapping("/set")
    public String set(){
        RedisUtil bean = SpringUtil.getBean(RedisUtil.class);
        boolean ticketcount = bean.hset("seckill", "1", 5);
        if(ticketcount){
            return "补票成功，补票数量为："+bean.get("ticketcount");
        }else{
            return "补票失败";
        }

    }

}
