package com.qianfeng.wfx.manager.goods.service.impl;

import com.qianfeng.wfx.manager.goods.mapper.GoodMapper;
import com.qianfeng.wfx.manager.goods.po.WxbGood;
import com.qianfeng.wfx.manager.goods.service.IWxbGoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



@Service
public class WxbGoodServiceImpl implements IWxbGoodService {

    @Resource
    private GoodMapper goodMapper;


//    @Override
//    public void saveGoods(WxbGood wxbGood) {
//
//        String ids = UUID.randomUUID().toString();
//        wxbGood.setGoodId(ids);
//        List<WxbGoodSku> goodSkuList = wxbGood.getGoodSkuList();
//        int size =goodSkuList.size();
//        for (int i=0;i<size;i++){
//            WxbGoodSku wxbGoodSku = goodSkuList.get(i);
//            wxbGoodSku.setSkuId(UUID.randomUUID().toString());
//            wxbGoodSku.setGoodId(ids);
//        }
//        goodMapper.saveGoods(wxbGood);
//        goodMapper.saveGoodsSku(goodSkuList);
//    }


    @Override
    public List<WxbGood> queryGoodsList() {
        List<WxbGood> goodlist = goodMapper.queryGoodsList();
        return goodlist;
    }

    @Override
    public void updateGoodsState(int state, String goodsId) {
        goodMapper.updateGoodsState(state,goodsId);
    }

    @Override
    public void delGoodById(String goodId) throws Exception {
        goodMapper.delGoodById(goodId);
    }
}
