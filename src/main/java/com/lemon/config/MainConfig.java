package com.lemon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 配置类
 */
@ComponentScan({"com.lemon.consumer","com.lemon.service","com.lemon.task","com.lemon.aop","com.lemon.util"})
@Configuration
@EnableAspectJAutoProxy
@EnableAsync
public class MainConfig {

}
