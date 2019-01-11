package com.mx.api.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BaseController {
    public static String renderNewJson(Integer errCode, String errMsg, Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errCode", errCode);
        jsonObject.put("errMsg", errMsg);
        jsonObject.put("data", data);
        return JSON.toJSONString(jsonObject);
    }
}
