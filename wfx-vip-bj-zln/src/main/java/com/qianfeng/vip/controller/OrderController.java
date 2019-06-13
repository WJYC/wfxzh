package com.qianfeng.vip.controller;

import com.github.wxpay.sdk.MyWXConfig;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qianfeng.vip.po.OrderInfo;
import com.qianfeng.vip.service.IOrderService;
import com.qianfeng.vip.vo.GoodsInfo;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 下单和支付
 */

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/add")
    public String addOrder(GoodsInfo goodsInfo, Model model){



        try {
            //生成订单号
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String currentDate = simpleDateFormat.format(new Date());


            Random random = new Random();
            int nextInt = random.nextInt();

            String orderId = currentDate+nextInt;

            //1、后台系统下单
            OrderInfo orderInfo = new OrderInfo(orderId, "18900001111", "goods_id", currentDate, "PC", "0", "1", "湖北省", "武汉市", "江夏区", "少辣", "wxpay", "张三", goodsInfo.getSkuName(), "详细地址");
            orderService.addOrder(orderInfo);


            //2、微信下单
            //---------微信预付单----------------------
            //微信API
            WXPay wxPay = new WXPay(new MyWXConfig());
            Map<String, String> data = new HashMap<String, String>();




            //商品的名称
            data.put("body", "千锋牛仔裤/面膜");
            //订单号（自定义），不能重复
            data.put("out_trade_no", orderId);
            //设备信息
            data.put("device_info", "PC");
            //币种
            data.put("fee_type", "CNY");
            //订单金额（单位是分）
            data.put("total_fee", "1");
            //设备IP
            data.put("spbill_create_ip", "123.12.12.123");
            //回调接口（微信支付完之后的通知接口）
            data.put("notify_url", "http://n8fdr7.natappfree.cc/order/notify");
            //支付模式native或者jsapi
            data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
            //产品ID自定义
            data.put("product_id", "12");

            //下预付单（下给微信了）
            //返回值是一个支付短链接
            Map<String, String> resp = wxPay.unifiedOrder(data);
            //支付的短链接
            String code_url = resp.get("code_url");
            //---------微信预付单----------------------

            model.addAttribute("code",code_url);


        } catch (Exception e) {
            e.printStackTrace();

            return "error";
        }

        return "pay";
    }


    @RequestMapping("/qrcode")
    public void qrcode(String codeUrl,HttpServletResponse response){
        //-------------通过微信支付短链接生成二维码---------
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //二维码精度，M精度中等
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            //参数1:生成二维码的文本
            //参数2：生成二维码类（也可以生成条形码）
            //参数3：图片的长宽
            BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl, BarcodeFormat.QR_CODE, 200, 200, hints);
            //将生成的图片流写入返回对象的输出流中
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
            System.out.println("创建二维码完成");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //-------------通过微信支付短链接生成二维码---------
    }

    /**
     *
     * 接收微信支付成功与否的通知
     *
     * 微信的通知规则：
     *
     * @return
     */
    @RequestMapping("/notify")
    public void notifyUrl(HttpServletRequest request,HttpServletResponse response){
        try {
            ServletInputStream inputStream = request.getInputStream();
            byte[] buffer = new byte[1024];
            int len =0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len=inputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer,0,len));
            }

            System.out.println("微信通知："+stringBuilder.toString());

            //获取微信返回的订单号
            Map<String, String> xmlToMap = WXPayUtil.xmlToMap(stringBuilder.toString());

            response.getWriter().println("<xml>\n" +
                    "\n" +
                    "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                    "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                    "</xml>");

            //付款完成之后，修改订单状态为已支付
            orderService.updateOrderState(xmlToMap.get("out_trade_no"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //-----------------goeasy推送消息给页面，进行页面刷新-------------------
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-bb260d5008904e028946290c1dafa24f");
        //参数1：发送消息的频道.zhangsan 表示消息只发给张三
        goEasy.publish("ligouzi", "success");

        jmsMessagingTemplate.convertAndSend("merchant","这是VIP发送的消息");

    }
}
