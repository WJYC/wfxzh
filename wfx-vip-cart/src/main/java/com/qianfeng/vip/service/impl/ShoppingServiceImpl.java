package com.qianfeng.vip.service.impl;

import com.qianfeng.vip.mapper.ShoppingMapper;
import com.qianfeng.vip.po.TbShoppingCar;
import com.qianfeng.vip.service.IShoppingService;
import com.qianfeng.vip.vo.JsonResult;
import com.qianfeng.vip.vo.MerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingServiceImpl implements IShoppingService{

    @Autowired
    private ShoppingMapper shoppingMapper;

    @RequestMapping(value = "addshopping",method = RequestMethod.POST)
    @Override
    public JsonResult addshopping(@RequestBody TbShoppingCar shoppingCar) {
        shoppingMapper.addshopping(shoppingCar);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(1);
        return jsonResult;
    }

    @RequestMapping(value = "shoppingList",method = RequestMethod.GET)
    @Override
    public List<MerchantInfo> queryShoppingList() {

        List<MerchantInfo> merchantInfoList = shoppingMapper.queryShoppingList();
        return merchantInfoList;
    }


}
