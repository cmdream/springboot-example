package com.test.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class App {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入代理服务客户端端口号");
		Integer port = sc.nextInt();
		ServerSocket server = new ServerSocket(port);
		while(true) {
			Socket socket = server.accept();
			SystemVal.aMqServer.amqInit();
			SystemVal.aMqServer.createRouteModel(socket);
			SystemVal.aMqServer.MessageChannelConfig();
			SystemVal.timerServer.timer();
		}
	}
	
	

}
