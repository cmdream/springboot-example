package com.mx.api.application.alarm.model;

import lombok.Data;

@Data
public class Alarm {
	//消息配置
	private String zhcq;//智慧城区
	private String systemId;//系统唯一标识
	private String systemName;//系统名称
	private String eventType;//事件类型
	private String eventLevel;//事件等级
	private String eventLevelName;//事件等级名称
	private String eventDescription;//事件描述
	//user
	private String userId;//用户id
	private String userName;//用户名
	private String orgId;//公司id
	private String orgName;//公司名称
	private String sendMode;//联系方式
	private String information;//联系信息
	//事件定制
	private String remarks;//备注
	private String eventName;//事件名称
	
	//p_code
	private String code;//p_code
	private String detailCode;//detail_code
	private String comment;//detail_code--名称
	//zhcq
	private String cqh;//城区号
	private String cqlx;//城区类型
	private String xzqh;//行政区划
	private String zhcqjc;//智慧城区简称
	private String zhcqmc;//智慧城区名称
	
}
