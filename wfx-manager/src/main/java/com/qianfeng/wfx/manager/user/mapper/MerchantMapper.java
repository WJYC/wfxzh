package com.qianfeng.wfx.manager.user.mapper;

import com.qianfeng.wfx.manager.user.po.WebCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface MerchantMapper {
    List<WebCustomer> queryMerchantList();
    void saveMerchantInfo(WebCustomer customer);
}
