package com.test.test;

import java.net.Socket;
import java.util.Date;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 路由对象
 * @author home
 *
 */
public class RouteModel {
	private Socket socket;
	private Connection connection;
	private Channel channelSend;
	private Channel channelRec;
	private String RouteId;
	private long timeStrap = System.currentTimeMillis();
	private Thread threadSocket;
	
	
	@Override
	public String toString() {
		return "RouteModel [socket=" + socket.isClosed() + ",timeStrap=" + new Date(timeStrap) + ", threadSocket="
				+ threadSocket.isAlive() + "]";
	}
	public Thread getThreadSocket() {
		return threadSocket;
	}
	public void setThreadSocket(Thread threadSocket) {
		this.threadSocket = threadSocket;
	}
	public long getTimeStrap() {
		return timeStrap;
	}
	public void setTimeStrap(long timeStrap) {
		this.timeStrap = timeStrap;
	}
	public String getRouteId() {
		return RouteId;
	}
	public void setRouteId(String routeId) {
		RouteId = routeId;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Channel getChannelSend() {
		return channelSend;
	}
	public void setChannelSend(Channel channelSend) {
		this.channelSend = channelSend;
	}
	public Channel getChannelRec() {
		return channelRec;
	}
	public void setChannelRec(Channel channelRec) {
		this.channelRec = channelRec;
	}
	
	/**
	 * 路由对象销毁
	 */
	public void destory() {
		try {
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			channelSend.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			channelRec.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
