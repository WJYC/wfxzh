package com.qianfeng.wfx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 允许当前项目作为Eureka注册中心启动
 */
@EnableZuulProxy //当前服务器是一个路由服务器
@EnableEurekaClient
@SpringBootApplication
public class ZuulBjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulBjApplication.class, args);
	}

}

