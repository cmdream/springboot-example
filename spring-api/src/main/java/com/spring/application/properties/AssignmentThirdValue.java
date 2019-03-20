package com.spring.application.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AssignmentThirdValue {
    @Autowired
    private Environment environment;
    public Map<String, Object> env() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("url3", environment.getProperty("properties.url3"));
        map.put("title3", new String(environment.getProperty("properties.title3").getBytes("ISO-8859-1"), "UTF-8"));
        return map;
    }
}
