package com.spring.application.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class AlongJsonUtils {
    /**
     * 将json字符串转换为Java对象 <T>代表泛型
     */
    public static <T> T jsonStr2JavaObj(String jsonStr, Class<T> objClass){
        JSONObject json = JSONObject.parseObject(jsonStr);
        return JSONObject.toJavaObject(json,objClass);

    }
    /**
     * 将json字符串转换为List
     */
    public static <T> List<T> jsonStr2List(String jsonStr, Class<T> objClass){
        JSONArray jsonArr = JSONArray.parseArray(jsonStr);
        return jsonArr.toJavaList(objClass);
    }
}
