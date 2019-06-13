package com.qianfeng.merchant.controller;

import com.qianfeng.merchant.po.WxbGood;
import com.qianfeng.merchant.po.WxbGoodType;
import com.qianfeng.merchant.service.IWxbGoodService;
import com.qianfeng.merchant.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private IWxbGoodService wxbGoodService;

    @RequestMapping("/typeList")
    public String queryTypeList(Model model){
        List<WxbGoodType> typeList = wxbGoodService.queryTypeList();
        model.addAttribute("typelist",typeList);
        return "goods-add";
    }

    @RequestMapping("/goodList")
    public String queryGoodsList(Model model){
        List<WxbGood> goodList = wxbGoodService.queryGoodsList();
        model.addAttribute("goodList",goodList);
        return "goods-list";
    }

    @RequestMapping("/delGood")
    @ResponseBody
    public JsonResult delGood(String goodId){
        JsonResult jsonResult = new JsonResult();
        try {
            wxbGoodService.delGoodById(goodId);
            jsonResult.setCode(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

    @RequestMapping("/saveGoods")
    @ResponseBody
    public JsonResult saveGoods(@RequestBody WxbGood wxbGood){
        JsonResult jsonResult = new JsonResult();
        wxbGood.setCustomerId("69609206");
        wxbGoodService.saveGoods(wxbGood);
        jsonResult.setCode(1);
        return jsonResult;
    }

}

