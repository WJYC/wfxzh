package com.qianfeng.wfx.manager.user.service.impl;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void login() throws Exception {
        String salt = "xiaowei28486868";
        //MD5加密
        Md5Hash md5Hash = new Md5Hash("123456",salt);
        String hex = md5Hash.toHex();
        System.out.println(hex);
    }

}