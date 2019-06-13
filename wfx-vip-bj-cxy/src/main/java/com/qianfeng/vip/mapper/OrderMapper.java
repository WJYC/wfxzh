package com.qianfeng.vip.mapper;

import com.qianfeng.vip.po.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {

    void addOrder(OrderInfo orderInfo);

    void updateOrderState(@Param("orderId") String orderId);
}
