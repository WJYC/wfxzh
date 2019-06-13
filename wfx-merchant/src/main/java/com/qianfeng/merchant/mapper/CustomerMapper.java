package com.qianfeng.merchant.mapper;

import com.qianfeng.merchant.po.WxbCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CustomerMapper {
    WxbCustomer findByLoginName(@Param("loginName") String loginName);
}
