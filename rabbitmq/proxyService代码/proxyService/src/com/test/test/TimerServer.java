package com.test.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerServer {
	
	
	public void timer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		   public void run() {
			  if(SystemVal.routeModel != null) {
		      System.out.println(SystemVal.routeModel.toString());
		       if(System.currentTimeMillis() - SystemVal.routeModel.getTimeStrap() > 1000 * 120) {
		    	   SystemVal.routeModel.destory();
		    	   SystemVal.routeModel = null;
		       }
			  }else {
				  System.out.println("no Conntion");
			  }
		   }
		},1000, 30 * 1000);// 设定指定的时间time,此处为2000毫秒
	}
}
