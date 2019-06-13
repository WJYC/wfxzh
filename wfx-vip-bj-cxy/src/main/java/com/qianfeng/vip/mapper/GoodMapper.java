package com.qianfeng.vip.mapper;

import com.qianfeng.vip.po.WxbGood;
import com.qianfeng.vip.po.WxbGoodSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodMapper {

    List<WxbGood> queryGoodsList();

    List<WxbGoodSku> queryGoodSkuList(@Param("goodsId") String goodsId);

    WxbGood queryGoodById(@Param("goodsId") String goodsId);

}
