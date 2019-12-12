package com.lemon.consumer;

import com.lemon.task.ITicketFailBackExecutor;
import com.lemon.task.ITicketSuccessBackExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {

    @Autowired
    Map<String, ITicketFailBackExecutor> failExecutorMap;

    @Autowired
    Map<String, ITicketSuccessBackExecutor> successExecutorMap;

    public void consumerMsg(Map<String, Boolean> map){
        for(String orderSn : map.keySet()){
            if(map.get(orderSn)){
                // 成功
                for(ITicketSuccessBackExecutor executor : successExecutorMap.values()){
                    try {
                        executor.execute(orderSn);
                    } catch (Exception e) {
                        System.out.println("consumer catch "+e.getMessage());
                    }
                }
            }else{
                // 失败
                for(ITicketFailBackExecutor executor : failExecutorMap.values()){
                    try {
                        executor.execute(orderSn);
                    } catch (Exception e) {
                        System.out.println("consumer catch "+e.getMessage());
                    }
                }
            }
        }
    }
}
