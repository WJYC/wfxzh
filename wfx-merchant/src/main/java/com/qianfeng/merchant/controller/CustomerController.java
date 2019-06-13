package com.qianfeng.merchant.controller;


import com.qianfeng.merchant.vo.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String loginName,String loginPwd){

        JsonResult jsonResult = new JsonResult();
        try{
            UsernamePasswordToken token =new UsernamePasswordToken(loginName,loginPwd);
            SecurityUtils.getSubject().login(token);
            jsonResult.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setCode(0);
        }
        return jsonResult;
    }
}
