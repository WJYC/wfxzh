package com.qianfeng.vip.service.impl;

import com.qianfeng.vip.mapper.MemberMapper;
import com.qianfeng.vip.po.WxbMemeber;
import com.qianfeng.vip.service.IMemberService;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements IMemberService{
    @Autowired
    private MemberMapper memberMapper;


    @Override
    public WxbMemeber querayByName(String account,String password)throws Exception{
        if(account==null){
            throw new NullPointerException("username is null");
        }
        if(password==null){
            throw new NullPointerException("password is null");
        }
        WxbMemeber wxbMemeber = memberMapper.querayByName(account);
        if(wxbMemeber==null){
            throw new UnknownAccountException();
        }
        return wxbMemeber;
    }
}
