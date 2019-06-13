package com.qianfeng.vip.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qianfeng.vip.po.TbShoppingCar;
import com.qianfeng.vip.po.WxbGood;
import com.qianfeng.vip.service.IWxbGoodService;
import com.qianfeng.vip.vo.JsonResult;
import com.qianfeng.vip.vo.MerchantInfo;
import org.apache.log4j.Logger;
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

    private Logger logger = Logger.getLogger("保健商城");

    /**
     * 查询商品列表
     * @param model
     * @return
     */
    @RequestMapping("/cxy/list")
    public String queryGoodsList1(Model model){
        logger.info("保健商城-调用程序员保健入口");
        WxbGood[] goods = restTemplate.getForObject("http://zuul-server/cxy/goods/list", WxbGood[].class);
        List<WxbGood> goodList = goodsService.queryGoodsList();
        model.addAttribute("goodsList",goodList);
        return "goods-list";
    }
    /**
     * 查询商品列表
     * @param model
     * @return
     */
    @RequestMapping("/zln/list")
    public String queryGoodsList2(Model model){
        logger.info("保健商城-调用中老年保健入口");
        WxbGood[] goods = restTemplate.getForObject("http://zuul-server/zln/goods/list", WxbGood[].class);
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
    @HystrixCommand(fallbackMethod ="addShoppingB")
    public JsonResult addShopping(String goodsId, String sku){

        TbShoppingCar tbShoppingCar = new TbShoppingCar();
        tbShoppingCar.setShpGoodsId(goodsId);
        tbShoppingCar.setShpGoodsNum(1);
        tbShoppingCar.setShpGoodsSku(sku);
        tbShoppingCar.setShpUserId("47376995");
        tbShoppingCar.setShpMerchantId("69609206");

        JsonResult jsonResult = restTemplate.postForObject("http://wfx-cart1/add", tbShoppingCar, JsonResult.class);

        return jsonResult;


    }
    public JsonResult addShoppingB(String goodsId, String sku){

        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("触发熔断机制");
        return jsonResult;


    }

    @RequestMapping("/shoppingList")
    public String queryShoppingList(Model model){
        MerchantInfo[] merchantInfos = restTemplate.getForObject("http://wfx-cart1/list", MerchantInfo[].class);
        List<MerchantInfo> list = Arrays.asList(merchantInfos);
        model.addAttribute("list",list);
        return "shoppingcart";
    }




}
