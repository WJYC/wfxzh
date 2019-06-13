package com.qianfeng.vip.service;


import com.qianfeng.vip.po.OrderInfo;

public interface IOrderService {

    void addOrder(OrderInfo orderInfo) throws Exception;

    void updateOrderState(String orderId) throws Exception;
}
