package com.lemon.service;

public interface ITicketService {

    public void handleFail(String orderSn) throws Exception;
    public void handleSucc(String orderSn) throws Exception;
}
