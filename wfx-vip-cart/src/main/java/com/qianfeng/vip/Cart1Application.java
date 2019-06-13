package com.qianfeng.vip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan("com.qianfeng.vip.mapper")
@SpringBootApplication
public class Cart1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cart1Application.class, args);
	}


}
