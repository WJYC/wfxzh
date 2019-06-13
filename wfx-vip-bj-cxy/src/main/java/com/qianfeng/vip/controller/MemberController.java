package com.qianfeng.vip.controller;

import com.qianfeng.vip.vo.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String account,String password){

        JsonResult jsonResult = new JsonResult();
        try{
            UsernamePasswordToken token =new UsernamePasswordToken(account,password);
            SecurityUtils.getSubject().login(token);
            jsonResult.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setCode(0);
        }
        return jsonResult;
    }
}
