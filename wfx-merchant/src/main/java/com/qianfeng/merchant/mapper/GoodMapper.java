package com.qianfeng.merchant.mapper;

import com.qianfeng.merchant.po.WxbGood;
import com.qianfeng.merchant.po.WxbGoodSku;
import com.qianfeng.merchant.po.WxbGoodType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodMapper {
    List<WxbGoodType> queryTypeList();
    void saveGoods(WxbGood wxbGood);
    void saveGoodsSku(@Param("skuList") List<WxbGoodSku> wxbGoodSkuList);
    List<WxbGood> queryGoodsList();
    void delGoodById(@Param("goodId") String goodId) throws Exception;
}
