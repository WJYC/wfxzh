package com.qianfeng.vip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableHystrix
@MapperScan("com.qianfeng.vip.mapper")
@SpringBootApplication
public class BjApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjApplication.class, args);
	}


}
