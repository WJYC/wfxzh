package com.qianfeng.vip.service;

import com.qianfeng.vip.po.WxbMemeber;
import org.apache.ibatis.annotations.Param;

public interface IMemberService {
    WxbMemeber querayByName(@Param("account") String account, @Param("password")String password)throws Exception;
}
