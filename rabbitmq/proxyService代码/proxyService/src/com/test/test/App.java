package com.test.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class App {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("input ip:");
		String ip = sc.next();
		System.out.println("input port:");
		Integer Port = sc.nextInt();
		SystemVal.ip = ip;
		SystemVal.port = Port;
		SystemVal.aMqServer.amqInit();
		while(true) {
			if(SystemVal.routeModel == null) {
				SystemVal.aMqServer.createRouteModel();
				SystemVal.aMqServer.MessageChannelConfig();
				SystemVal.timerServer.timer();
			}else {
				Thread.sleep(2000);
			}
		}
		
	}
	
	

}
