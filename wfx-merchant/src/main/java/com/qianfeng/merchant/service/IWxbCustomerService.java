package com.qianfeng.merchant.service;

import com.qianfeng.merchant.po.WxbCustomer;
import org.apache.shiro.authc.AuthenticationException;

public interface IWxbCustomerService {
    WxbCustomer findByLoginName(String loginName, String loginPwd)throws NullPointerException, AuthenticationException;
}
