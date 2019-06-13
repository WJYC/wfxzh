package com.qianfeng.merchant.mq;

import io.goeasy.GoEasy;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class VIPMessageListener {

    @JmsListener(destination="merchant")
    public void listen(String msg){
        System.out.println("接收：" + msg);

        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-bb260d5008904e028946290c1dafa24f");
        //参数1：发送消息的频道.zhangsan 表示消息只发给张三
        goEasy.publish("merchant", "success");

    }
}
