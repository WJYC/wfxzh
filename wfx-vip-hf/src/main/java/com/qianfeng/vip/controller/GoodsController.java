package com.qianfeng.vip.controller;

import com.qianfeng.vip.po.TbShoppingCar;
import com.qianfeng.vip.po.WxbGood;
import com.qianfeng.vip.service.IWxbGoodService;
import com.qianfeng.vip.vo.JsonResult;
import com.qianfeng.vip.vo.MerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IWxbGoodService goodsService;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询商品列表
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String queryGoodsList(Model model){
        List<WxbGood> goodList = goodsService.queryGoodsList();
        model.addAttribute("goodsList",goodList);
        return "goods-list";
    }

    /**
     * 通过goodsId查询套餐列表
     * @param goodsId
     * @return
     */
    @RequestMapping("/details")
    public String queryGoodsDetailsByGoodsId(Model model,String goodsId){
        WxbGood wxbGood = goodsService.queryGoodById(goodsId);
        model.addAttribute("goods",wxbGood);
        return "goods-details";
    }

    @RequestMapping("/addshopping")
    @ResponseBody
    public JsonResult addShopping(String goodsId, String sku){
        TbShoppingCar tbShoppingCar = new TbShoppingCar();
        tbShoppingCar.setShpGoodsId(goodsId);
        tbShoppingCar.setShpGoodsNum(1);
        tbShoppingCar.setShpGoodsSku(sku);
        tbShoppingCar.setShpUserId("47376995");
        tbShoppingCar.setShpMerchantId("69609206");

        JsonResult jsonResult = restTemplate.postForObject("http://wfx-cart1/addshopping", tbShoppingCar, JsonResult.class);
        return jsonResult;
    }

    @RequestMapping("/shoppingList")
    public String queryShoppingList(Model model){
        MerchantInfo[] merchantInfos = restTemplate.getForObject("http://wfx-cart1/shoppingList", MerchantInfo[].class);
        List<MerchantInfo> list = Arrays.asList(merchantInfos);
        model.addAttribute("list",list);
        return "shoppingcart";
    }




}
