package com.qianfeng.wfx.manager.goods.service;

import com.qianfeng.wfx.manager.goods.po.WxbGood;

import java.util.List;

public interface IWxbGoodService {
//    void saveGoods(WxbGood wxbGood);
    List<WxbGood> queryGoodsList();
    void updateGoodsState( int state,String goodsId);
    void delGoodById(String goodId) throws Exception;
}
