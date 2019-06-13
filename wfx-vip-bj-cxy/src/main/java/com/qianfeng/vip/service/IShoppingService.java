package com.qianfeng.vip.service;

import com.qianfeng.vip.po.TbShoppingCar;
import com.qianfeng.vip.vo.MerchantInfo;

import java.util.List;

public interface IShoppingService {
    void addshopping(TbShoppingCar shoppingCar);
    List<MerchantInfo> queryShoppingList();
}
