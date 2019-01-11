package com.mx.api.application.gis.service;

import com.mx.api.application.gis.mapping.GisMapper;
import com.mx.api.application.gis.model.Gis;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GisService {
    @Resource
    GisMapper gisMapper;
    /**
     * 查询智慧城区下拉
     */
    public List<Gis> queryZhcqName(Gis gis) {
        return gisMapper.queryZhcqName(gis);
    }

}
