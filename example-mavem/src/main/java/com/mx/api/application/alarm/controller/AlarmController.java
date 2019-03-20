package com.mx.api.application.alarm.controller;

import com.mx.api.application.alarm.model.Alarm;
import com.mx.api.application.alarm.service.AlarmService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/alarmController")
public class AlarmController {
	@Autowired
	private AlarmService alarmService;
	
	@ApiOperation("1.获得config")
	@GetMapping("/getConfig")
	public String getConfig() {
		return alarmService.getConfig();
	}
	/**
	 * @description 发送方式
	 * @param code uc1004--发送方式
	 */
	@ApiOperation("2.发送方式")
	@GetMapping("/queryCodeDetail")
	public List<Alarm> queryCodeDetail(@RequestParam String code){
		return alarmService.queryCodeDetail(code);
	}

}
