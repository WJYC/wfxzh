package com.qianfeng.wfx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qianfeng.wfx.mapper")
@SpringBootApplication
public class WfxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfxApplication.class, args);
	}

}
