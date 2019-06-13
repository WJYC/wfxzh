package com.qianfeng.vip.service.impl;

import com.qianfeng.vip.mapper.GoodMapper;
import com.qianfeng.vip.po.WxbGood;
import com.qianfeng.vip.po.WxbGoodSku;
import com.qianfeng.vip.service.IWxbGoodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;



@Service
public class WxbGoodServiceImpl implements IWxbGoodService {

    @Resource
    private GoodMapper goodMapper;




    @Override
    public List<WxbGood> queryGoodsList() {
        List<WxbGood> goodlist = goodMapper.queryGoodsList();
        return goodlist;
    }

    @Transactional(readOnly=true)
    public List<WxbGoodSku> queryGoodSkuList(String goodsId) {
        List<WxbGoodSku> goodSkuList = goodMapper.queryGoodSkuList(goodsId);
        return goodSkuList;

    }

    @Transactional(readOnly=true)
    public WxbGood queryGoodById(String goodsId) {
        WxbGood wxbGood = goodMapper.queryGoodById(goodsId);

        //查询商品套餐
        List<WxbGoodSku> goodSkuList = queryGoodSkuList(goodsId);

        //一对多关系集合
        wxbGood.setGoodSkuList(goodSkuList);

        return wxbGood;
    }


}
