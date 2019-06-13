package com.qianfeng.wfx.manager.user.service;

import com.qianfeng.wfx.manager.user.po.WebCustomer;

import java.util.List;

public interface ImerchantService {
    List<WebCustomer> queryMerchantList() throws Exception;
    void saveMerchantInfo(WebCustomer customer)throws Exception;
}
