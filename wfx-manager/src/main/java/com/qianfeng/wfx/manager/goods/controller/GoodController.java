package com.qianfeng.wfx.manager.goods.controller;

import com.qianfeng.wfx.manager.goods.po.WxbGood;
import com.qianfeng.wfx.manager.goods.service.IWxbGoodService;
import com.qianfeng.wfx.manager.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private IWxbGoodService wxbGoodService;


    @RequestMapping("/goodList")
    public String queryGoodsList(Model model){
        List<WxbGood> goodList = wxbGoodService.queryGoodsList();
        model.addAttribute("goodList",goodList);
        return "goods-list";
    }

    @RequestMapping("/updateState")
    @ResponseBody
    public JsonResult updateGoodState(int state,String goodsId){
        JsonResult jsonResult = new JsonResult();
        try {
            wxbGoodService.updateGoodsState(state,goodsId);
            jsonResult.setCode(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

//    @RequestMapping("/saveGoods")
//    @ResponseBody
//    public JsonResult saveGoods(@RequestBody WxbGood wxbGood){
//        JsonResult jsonResult = new JsonResult();
//        wxbGood.setCustomerId("69609206");
//        wxbGoodService.saveGoods(wxbGood);
//        jsonResult.setCode(1);
//        return jsonResult;
//    }

}

