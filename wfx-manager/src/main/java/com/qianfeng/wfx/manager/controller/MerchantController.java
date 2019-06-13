package com.qianfeng.wfx.manager.controller;

import com.qianfeng.wfx.manager.user.po.WebCustomer;
import com.qianfeng.wfx.manager.user.service.ImerchantService;
import com.qianfeng.wfx.manager.vo.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private ImerchantService merchantService;

    @RequestMapping("/list")
    @RequiresPermissions({"商户信息管理"})
    public String queryMerchantInfoList(Model model){

        List<WebCustomer> customerList = null;
        try {
            customerList = merchantService.queryMerchantList();
            model.addAttribute("merchantList",customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "merchant-list";
    }
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult saveMerchantInfo(WebCustomer customer){

        JsonResult jsonResult = new JsonResult();
        try {
            merchantService.saveMerchantInfo(customer);
            jsonResult.setCode(1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(0);
        }


        return jsonResult;

    }

}
