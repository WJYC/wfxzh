package com.qianfeng.merchant.service.impl;

import com.qianfeng.merchant.mapper.CustomerMapper;
import com.qianfeng.merchant.po.WxbCustomer;
import com.qianfeng.merchant.service.IWxbCustomerService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxbCustomerServiceServiceImpl implements IWxbCustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public WxbCustomer findByLoginName(String loginName, String loginPwd) throws NullPointerException, AuthenticationException {
        if(loginName==null){
            throw new NullPointerException("username is null");
        }
        if(loginPwd==null){
            throw new NullPointerException("password is null");
        }
        WxbCustomer customer = customerMapper.findByLoginName(loginName);
        if(customer==null){
            throw new UnknownAccountException();
        }
        return customer;
    }
}
