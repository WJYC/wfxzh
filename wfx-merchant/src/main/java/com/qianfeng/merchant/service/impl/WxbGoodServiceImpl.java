package com.qianfeng.merchant.service.impl;

import com.qianfeng.merchant.mapper.GoodMapper;
import com.qianfeng.merchant.po.WxbGood;
import com.qianfeng.merchant.po.WxbGoodSku;
import com.qianfeng.merchant.po.WxbGoodType;
import com.qianfeng.merchant.service.IWxbGoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;



@Service
public class WxbGoodServiceImpl implements IWxbGoodService {

    @Resource
    private GoodMapper goodMapper;

    @Override
    public List<WxbGoodType> queryTypeList() {
        List<WxbGoodType> goodTypes = goodMapper.queryTypeList();
        return goodTypes;
    }

    @Override
    public void saveGoods(WxbGood wxbGood) {


        String ids = UUID.randomUUID().toString();
        wxbGood.setGoodId(ids);
        List<WxbGoodSku> goodSkuList = wxbGood.getGoodSkuList();
        int size =goodSkuList.size();
        for (int i=0;i<size;i++){
            WxbGoodSku wxbGoodSku = goodSkuList.get(i);
            wxbGoodSku.setSkuId(UUID.randomUUID().toString());
            wxbGoodSku.setGoodId(ids);
        }
        goodMapper.saveGoods(wxbGood);
        goodMapper.saveGoodsSku(goodSkuList);
    }


    @Override
    public List<WxbGood> queryGoodsList() {
        List<WxbGood> goodlist = goodMapper.queryGoodsList();
        return goodlist;
    }

    @Override
    public void delGoodById(String goodId) throws Exception {
        goodMapper.delGoodById(goodId);
    }
}
