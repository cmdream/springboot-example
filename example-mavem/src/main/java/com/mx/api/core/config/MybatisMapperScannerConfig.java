package com.mx.api.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cheng on 2016/3/11.
 */
@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
@MapperScan("com.mx.api.application.*.mapping")
public class MybatisMapperScannerConfig {

   /*@Bean
    public MapperScannerConfigurer utilMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.mx.api.application.gis.mapping");
        return mapperScannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer secondMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("secondSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.mx.api.application.alarm.mapping");
        return mapperScannerConfigurer;
    }*/
}
