package com.mx.api.test.socketTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


class dataProcess implements Runnable{
	private InputStream in;
	private OutputStream out;
	
	public dataProcess(Socket sock1,Socket sock2) {
		try {
			this.in = sock1.getInputStream();
			this.out = sock2.getOutputStream();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			// TODO Auto-generated method stub
			try {
				byte[] buf = new byte[1024];
				int len = -1;
				while((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
					out.flush();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}	
}

public class Test12 {
	
	public static void main(String args[]) throws Exception{
		try {
			ServerSocket server = new ServerSocket(55533); 
			System.out.println("server wait....");
			Socket socket = server.accept();
			System.out.println("client connectin....");
			Socket socketssh = new Socket("122.113.5.246",22);
			new Thread(new dataProcess(socket,socketssh)).start();
			new Thread(new dataProcess(socketssh,socket)).start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
