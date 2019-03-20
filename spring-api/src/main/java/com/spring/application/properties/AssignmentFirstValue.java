package com.spring.application.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.@ConfigurationProperties(prefix = "properties")
 * @since JDK：1.7
 */
@Component
@ConfigurationProperties(prefix = "properties")
public class AssignmentFirstValue {
    private String url1;
    private String title1;
    private Map<String, String> login = new HashMap<>();
    private List<String> urls = new ArrayList<>();
    @Value("json.cn")
    private String jsonUrl1;

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getTitle1() {
        try {
            return new String(title1.getBytes("ISO-8859-1"), "UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public Map<String, String> getLogin() {
        return login;
    }

    public void setLogin(Map<String, String> login) {
        this.login = login;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getJsonUrl1() {
        return jsonUrl1;
    }

    public void setJsonUrl1(String jsonUrl1) {
        this.jsonUrl1 = jsonUrl1;
    }
}
