package com.lemon.thread;

import com.lemon.util.RedisUtil;
import com.lemon.util.SpringUtil;

public class MyThread extends Thread {

    RedisUtil bean = SpringUtil.getBean(RedisUtil.class);

    @Override
    public void run() {

        if(bean.hincr("seckill", "1", -1) >= 0){
            System.out.println(Thread.currentThread().getId()+"号窗口卖出一张票");
        }else{
           bean.hincr("seckill", "1", 1);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception ex){
            System.out.println("异常被捕捉，释放库存");
            bean.hset("seckill", "1", 1);
        }
    }

    @Override
    public synchronized void start() {
        super.start();
    }
}
