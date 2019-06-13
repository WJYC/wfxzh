package com.qianfeng.wfx.manager.goods.mapper;


import com.qianfeng.wfx.manager.goods.po.WxbGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodMapper {
//    void saveGoods(WxbGood wxbGood);
//    void saveGoodsSku(@Param("skuList") List<WxbGoodSku> wxbGoodSkuList);
    List<WxbGood> queryGoodsList();
    void updateGoodsState(@Param("state") int state,@Param("goodsId") String goodsId);
    void delGoodById(@Param("goodId") String goodId) throws Exception;
}
