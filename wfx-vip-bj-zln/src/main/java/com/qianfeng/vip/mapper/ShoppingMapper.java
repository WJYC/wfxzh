package com.qianfeng.vip.mapper;

import com.qianfeng.vip.po.TbShoppingCar;
import com.qianfeng.vip.vo.MerchantInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShoppingMapper {
    void addshopping(TbShoppingCar shoppingCar);
    List<MerchantInfo> queryShoppingList();
}
