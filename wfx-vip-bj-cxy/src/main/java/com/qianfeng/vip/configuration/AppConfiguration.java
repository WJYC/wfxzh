package com.qianfeng.vip.configuration;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate provideRestTemplate(){
        return new RestTemplate();
    }
}
