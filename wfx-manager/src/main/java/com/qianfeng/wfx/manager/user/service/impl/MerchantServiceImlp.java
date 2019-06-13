package com.qianfeng.wfx.manager.user.service.impl;

import com.qianfeng.wfx.manager.user.mapper.MerchantMapper;
import com.qianfeng.wfx.manager.user.po.WebCustomer;
import com.qianfeng.wfx.manager.user.service.ImerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MerchantServiceImlp implements ImerchantService{

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public List<WebCustomer> queryMerchantList() throws Exception{
        List<WebCustomer> webCustomers = merchantMapper.queryMerchantList();
        return webCustomers;
    }

    @Override
    public void saveMerchantInfo(WebCustomer customer) throws Exception{
        customer.setCustomerId(UUID.randomUUID().toString());
        customer.setCreatetime(new Timestamp(new Date().getTime()));
        merchantMapper.saveMerchantInfo(customer);
    }
}
