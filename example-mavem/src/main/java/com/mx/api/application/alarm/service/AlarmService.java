package com.mx.api.application.alarm.service;

import com.mx.api.application.alarm.mapping.AlarmMapper;
import com.mx.api.application.alarm.model.Alarm;
import com.mx.api.core.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlarmService  {
	@Resource
	Config config;
//	@Resource
	@Autowired
	AlarmMapper alarmMapper;
//	private String PORTAL_SERVER_URL= config.getPORTAL_SERVER_URL();//请求portal2018 Url
	
	public String getConfig() {
		System.out.println("==============="+config.getPORTAL_SERVER_URL());
		return config.getPORTAL_SERVER_URL();
	}
	/**
	 * @description 发送方式
	 * @param p_code uc1003--发送方式
	 */
	public List<Alarm> queryCodeDetail(String code) {
		return alarmMapper.queryCodeDetail(code);
	}

}
