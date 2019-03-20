package com.mx.api.application.gis.service;

import com.alibaba.fastjson.JSON;
import com.mx.api.application.gis.mapping.GisMapper;
import com.mx.api.application.gis.model.Gis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GisService {
//    @Resource
    @Autowired
    GisMapper gisMapper;
    /**
     * 查询智慧城区下拉
     */
    public List<Gis> queryZhcqName(Gis gis) {
        return gisMapper.queryZhcqName(gis);
    }
    /**
     * 异常处理测试
     */
    public String exceptionTest(String id) {
//        int s = 0+Integer.valueOf(id);
        return "fail";
    }
    public String queryIpoleAppSystem() {
        List<Gis> list = gisMapper.queryIpoleAppSystem();
        return JSON.toJSONString(list);
    }

}
