package com.mx.api.core.config;

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
public class Config {
//    @Value("${SSO_SERVER_URL}")
//    private String SSO_SERVER_URL;
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

    public String getNotIntercepted() {
        return notIntercepted;
    }

    public void setNotIntercepted(String notIntercepted) {
        this.notIntercepted = notIntercepted;
    }

    public String getSYSTEM_NUMBER() {
        return SYSTEM_NUMBER;
    }

    public void setSYSTEM_NUMBER(String SYSTEM_NUMBER) {
        this.SYSTEM_NUMBER = SYSTEM_NUMBER;
    }

    public String getSSO_SERVER_URL() {
        return SSO_SERVER_URL;
    }

    public void setSSO_SERVER_URL(String SSO_SERVER_URL) {
        this.SSO_SERVER_URL = SSO_SERVER_URL;
    }

    public String getLOGIN_PAGE_URL() {
        return LOGIN_PAGE_URL;
    }

    public void setLOGIN_PAGE_URL(String LOGIN_PAGE_URL) {
        this.LOGIN_PAGE_URL = LOGIN_PAGE_URL;
    }

    public String getPicturePreview() {
        return picturePreview;
    }

    public void setPicturePreview(String picturePreview) {
        this.picturePreview = picturePreview;
    }
}
