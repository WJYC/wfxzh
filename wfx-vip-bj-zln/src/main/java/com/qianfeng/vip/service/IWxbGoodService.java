package com.qianfeng.vip.service;


import com.qianfeng.vip.po.WxbGood;
import com.qianfeng.vip.po.WxbGoodSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWxbGoodService {
    List<WxbGood> queryGoodsList();

    List<WxbGoodSku> queryGoodSkuList(@Param("goodsId") String goodsId);

    WxbGood queryGoodById(@Param("goodsId") String goodsId);
}
