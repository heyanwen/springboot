package com.lemon.entity;

public class RetryInfo {

    private String orderSn;

    private boolean ticketOutResult;

    private String methodName;

    public RetryInfo(String orderSn, boolean ticketOutResult, String methodName) {
        this.orderSn = orderSn;
        this.ticketOutResult = ticketOutResult;
        this.methodName = methodName;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public boolean isTicketOutResult() {
        return ticketOutResult;
    }

    public void setTicketOutResult(boolean ticketOutResult) {
        this.ticketOutResult = ticketOutResult;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
