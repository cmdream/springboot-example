package com.mx.api.application.gis.mapping;

import com.mx.api.application.gis.model.Gis;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Mapper
public interface GisMapper {

    List<Gis> queryZhcqName(Gis gis);
    List<Gis> queryIpoleAppSystem();
}
