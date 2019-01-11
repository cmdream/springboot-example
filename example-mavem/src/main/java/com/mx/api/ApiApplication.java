package com.mx.api;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@MapperScan("com.mx.api.application.gis.mapping")
public class ApiApplication {
//	protected static final Logger logger = LoggerFactory.getLogger(ApiApplication.class);

	public static void main(String[] args) {
//		logger.info("springboot================info");
		SpringApplication.run(ApiApplication.class, args);
//		logger.debug("springboot===============debug");
	}

}

