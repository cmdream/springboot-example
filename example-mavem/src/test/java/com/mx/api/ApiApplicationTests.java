package com.mx.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j//代替private final Logger logger = LoggerFactory.getLogger(ApiApplicationTests.class);
public class ApiApplicationTests {

	//private final Logger logger = LoggerFactory.getLogger(ApiApplicationTests.class);
	@Test
	public void test1(){
		String name = "lzz";
		String password = "123456";
		log.debug("debug...");
		log.info("name:"+name+" password:"+password);
		//可以使用 {} 占位符来拼接字符串，而不需要使用 ““+”” 来连接字符串
		log.info("name:{},password:{}",name,password);
		log.error("error...");
		log.warn("warn....");
	}

}

