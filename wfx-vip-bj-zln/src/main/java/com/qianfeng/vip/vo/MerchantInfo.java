package com.qianfeng.vip.vo;

import java.util.List;

/**
 * 商家信息（购物车相关）
 */
public class MerchantInfo {

    private String merchantName;
    private List<GoodsInfo> goodsInfoList;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }
}
