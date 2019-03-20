package com.spring.application.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 2.@Component和@Value({"xxx"})   setter+getter
 * @since JDK：1.7
 */
@Component
public class AssignmentSecondValue {
    @Value("${properties.url2}")
    private String url2;
    @Value("${properties.title2}")
    private String title2;
    @Value("json.cn")
    private String jsonUrl2;

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getJsonUrl2() {
        return jsonUrl2;
    }

    public void setJsonUrl2(String jsonUrl2) {
        this.jsonUrl2 = jsonUrl2;
    }
}
