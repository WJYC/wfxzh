package com.qianfeng.vip.mapper;

import com.qianfeng.vip.po.WxbMemeber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MemberMapper {
    WxbMemeber querayByName(@Param("account") String account);
}
