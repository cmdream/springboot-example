package com.mx.api.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 在高版本的springboot中，@ConfigurationProperties(prefix = "wisely2",locations = "classpath:wisely.properties")这个注解不支持了
 */
@Component//扫描类
//@ConfigurationProperties(prefix = "config")//读取前缀为config的内容
@PropertySource(value = "classpath:config.properties")//定义了读取的properties的位置
@Data//这是lombok的一个注解，用于生成setter&getter方法
public class Config {
    @Value("${notIntercepted}")
    private String notIntercepted;
    @Value("${SYSTEM_NUMBER}")
    private String SYSTEM_NUMBER;
    @Value("${SSO_SERVER_URL}")
    private String SSO_SERVER_URL;
    @Value("${LOGIN_PAGE_URL}")
    private String LOGIN_PAGE_URL;
    @Value("${picturePreview}")
    private String picturePreview;
    @Value("${PORTAL_SERVER_URL}")
    private String PORTAL_SERVER_URL;

}
