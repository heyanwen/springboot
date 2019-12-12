package com.lemon.controller;

import com.lemon.consumer.Consumer;
import com.lemon.entity.RetryInfo;
import com.lemon.service.ITicketService;
import com.lemon.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    Consumer consumer;

    @RequestMapping("/test")
    public void test(int j){
        Map<String, Boolean> map = new HashMap<>();
        for(int i=0;i<j;i++){
            if(i%2==1){
                map.put("订单"+i, true);
            }else{
                map.put("订单"+i, false);
            }
        }
        consumer.consumerMsg(map);
    }

    @RequestMapping("/job")
    public void job(){
        List<RetryInfo> list = new ArrayList<>();
        list.add(new RetryInfo("order01", true, "cash"));
        list.add(new RetryInfo("order03", true, "redis"));
        for (RetryInfo retryInfo : list) {
            ITicketService bean = (ITicketService) SpringUtil.getBean(retryInfo.getMethodName());
            try{
                if(retryInfo.isTicketOutResult()){
                    bean.handleSucc(retryInfo.getOrderSn());
                }else{
                    bean.handleFail(retryInfo.getOrderSn());
                }
            }catch (Exception e){

            }

        }
    }

}
