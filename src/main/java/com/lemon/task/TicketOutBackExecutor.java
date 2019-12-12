package com.lemon.task;

/**
 * 任务接口
 */
public interface TicketOutBackExecutor {

    /**
     * 处理
     * @param orderSn
     */
    void execute(String orderSn) throws Exception;

}
