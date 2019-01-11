package com.mx.api.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j//@Slf4j注解代替了private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
//@Configuration
//@RunWith(JUnit4.class)//@RunWith注解，是一个运行器，指用JUnit4来运行
@RunWith(SpringRunner.class)//SpringRunner 继承了SpringJUnit4ClassRunner，没有扩展任何功能；使用前者，名字简短而已
//@RunWith(SpringJUnit4ClassRunner.class)//让测试环境运行于spring测试环境
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//配置bean
public class LoggerTest {
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    /*@Bean
    public String str(){
        return new String();
    }*/
//    @Resource
//    Date date;

    @Test
    public void test(){
        log.debug("test============debug");
//        System.out.println("==========="+date.toLocaleString());
    }

}
