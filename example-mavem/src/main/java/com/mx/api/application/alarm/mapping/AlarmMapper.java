package com.mx.api.application.alarm.mapping;

import com.mx.api.application.alarm.model.Alarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface AlarmMapper {
    List<Alarm> queryCodeDetail(String code);
}
