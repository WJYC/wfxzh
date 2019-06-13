package com.qianfeng.pay;

import com.github.wxpay.sdk.MyWXConfig;
import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class PayDemo {

    public static void main(String[] args) {
        try {
            WXPay wxPay = new WXPay(new MyWXConfig());
            Map<String, String> data = new HashMap<String, String>();
            data.put("body", "腾讯充值中心-QQ会员充值");
            data.put("out_trade_no", "2016090910595900000012");
            data.put("device_info", "");
            data.put("fee_type", "CNY");
            data.put("total_fee", "1");
            data.put("spbill_create_ip", "123.12.12.123");
            data.put("notify_url", "http://www.example.com/wxpay/notify");
            data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
            data.put("product_id", "12");

            try {
                Map<String, String> resp = wxPay.unifiedOrder(data);
                System.out.println(resp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
