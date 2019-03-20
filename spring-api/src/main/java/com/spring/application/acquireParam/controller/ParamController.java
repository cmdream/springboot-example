package com.spring.application.acquireParam.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.application.acquireParam.model.Param;
import com.spring.application.properties.AssignmentFirstValue;
import com.spring.application.properties.AssignmentSecondValue;
import com.spring.application.properties.AssignmentThirdValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "paramInfo")
@RestController
@RequestMapping("/paramController")
public class ParamController {

    @Autowired
    private AssignmentFirstValue assignmentFirstValue;
    @Autowired
    private AssignmentSecondValue assignmentSecondValue;
    @Autowired
    private AssignmentThirdValue assignmentThirdValue;

    @ApiOperation(value = "1.noneParam")
    @GetMapping("/noneParam")
    public String noneParam(){
        return "hello boy";
    }
    @ApiOperation(value = "2.问号传参，接收参数")
    @GetMapping("/acquireRequestParam")
    public String acquireRequestParam(@ApiParam("requestParam") @RequestParam("name") String name){
        return name;
    }
    @ApiOperation("3.斜杠传参")
    @GetMapping("/pathVariableParamer/{name}")
    public String pathVariableParamer(@ApiParam("pathVariable") @PathVariable("name") String name){
        return name;
    }

    @ApiOperation("4.properties获取参数")
    @GetMapping("/acquirePropertiesParamer")
    public Map<String, Object> acquirePropertiesParamer() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("url1", assignmentFirstValue.getUrl1());
        map.put("title1", assignmentFirstValue.getTitle1());
        map.put("login", assignmentFirstValue.getLogin());
        map.put("urls", assignmentFirstValue.getUrls());
        map.put("jsonUrl1", assignmentFirstValue.getJsonUrl1());

        map.put("url2", assignmentSecondValue.getUrl2());
        // *.properties文件中的中文默认以ISO-8859-1编码，因此需要对中文内容进行重新编码
        map.put("title2", new String(assignmentSecondValue.getTitle2().getBytes("ISO-8859-1"), "UTF-8"));
        map.put("jsonUrl2", assignmentSecondValue.getJsonUrl2());

        Map<String, Object> env = assignmentThirdValue.env();
        map.put("url3", env.get("url3"));
        map.put("title3", env.get("title3"));
        System.out.println(Charset.defaultCharset());
        map.put("defaultCharset", Charset.defaultCharset());
        return map;
//        "url: " + url + "  jsonUrl: " + jsonUrl + " url1: " + url1 + " jsonUrl1: " + jsonUrl1 + " url3: " + env.get("url") + " title3: " + env.get("title");
    }
    @ApiOperation("json字符串转Java对象")
    @GetMapping("/jsonStringToModel")
    public Param jsonStringToModel(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "花花");
        jsonObject.put("color", "blue");
        //json转字符串
        String s = jsonObject.toJSONString();
        String s1 = jsonObject.toString();
        JSONObject jsonObject1 = JSONObject.parseObject(s);
        System.out.println(s);
        System.out.println(s1);
        //json转Java对象
        Param param1 = jsonObject.toJavaObject(Param.class);
        System.out.println(param1);
        Param t = JSONObject.toJavaObject(jsonObject, Param.class);
        System.out.println(t);

        return param1;
    }
    @ApiOperation("/responseEntity返回数据")
    @GetMapping("/responseEntityExample")
    public ResponseEntity<Object> responseEntityExample(){
        String str = "Object";
        boolean flag = str instanceof Object;
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(flag));
        return ResponseEntity.ok(list);
    }
    @ApiOperation("responsebody返回数据")
    @GetMapping("/compareResponseEntity")
    public List<String> compareResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("true");
        return list;
    }




}
