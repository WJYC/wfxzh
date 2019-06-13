package com.qianfeng.merchant.service;

import com.qianfeng.merchant.po.WxbGood;
import com.qianfeng.merchant.po.WxbGoodType;

import java.util.List;

public interface IWxbGoodService {
    List<WxbGoodType> queryTypeList();
    void saveGoods(WxbGood wxbGood);
    List<WxbGood> queryGoodsList();
    void delGoodById(String goodId) throws Exception;
}
