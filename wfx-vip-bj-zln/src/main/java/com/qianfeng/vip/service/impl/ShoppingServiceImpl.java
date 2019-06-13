package com.qianfeng.vip.service.impl;

import com.qianfeng.vip.mapper.ShoppingMapper;
import com.qianfeng.vip.po.TbShoppingCar;
import com.qianfeng.vip.service.IShoppingService;
import com.qianfeng.vip.vo.MerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl implements IShoppingService{

    @Autowired
    private ShoppingMapper shoppingMapper;


    @Override
    public void addshopping(TbShoppingCar shoppingCar) {
        shoppingMapper.addshopping(shoppingCar);
    }

    @Override
    public List<MerchantInfo> queryShoppingList() {

        List<MerchantInfo> merchantInfoList = shoppingMapper.queryShoppingList();
        return merchantInfoList;
    }


}
