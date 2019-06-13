package com.qianfeng.vip.service.impl;

import com.qianfeng.vip.mapper.OrderMapper;
import com.qianfeng.vip.po.OrderInfo;
import com.qianfeng.vip.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Override
    public void addOrder(OrderInfo orderInfo) throws Exception {
        orderMapper.addOrder(orderInfo);

    }

    @Override
    public void updateOrderState(String orderId) throws Exception {
        orderMapper.updateOrderState(orderId);
    }
}
