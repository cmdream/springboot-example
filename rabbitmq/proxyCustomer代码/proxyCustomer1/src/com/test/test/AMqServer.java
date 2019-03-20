package com.test.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class AMqServer {
	private ConnectionFactory factory = null;
	/**
	 * 初始化
	 */
	public void amqInit() {
		factory = new ConnectionFactory();
        //设置RabbitMQ地址
        factory.setHost("118.190.217.134");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
	}
	
	/**
	 * 创建路由对象
	 * @param socket
	 * @return
	 * @throws Exception
	 */
	public void createRouteModel(Socket socket) throws Exception {
		RouteModel routeModel = new RouteModel();
		Connection connection = factory.newConnection();
		Channel channelSend = connection.createChannel();
		Channel channelRec = connection.createChannel();
		routeModel.setSocket(socket);
		routeModel.setChannelRec(channelRec);
		routeModel.setChannelSend(channelSend);
		routeModel.setConnection(connection);
		routeModel.setRouteId("tcpQueue");
		SystemVal.routeModel = routeModel;
	}
	
	/**
	 * 消息通道配置
	 * @param routeModel
	 */
	public void MessageChannelConfig() {
		try {
			RouteModel routeModel = SystemVal.routeModel;
			ReadSocket(routeModel);
			ReadMq(routeModel);
			messageControl(routeModel,"start");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从mq读取消息
	 * @param routeModel
	 * @throws Exception
	 */
	public void ReadMq(RouteModel routeModel) throws Exception {
		Consumer consumer = new DefaultConsumer(routeModel.getChannelRec()) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
            	 System.out.println(new String(body));
            	 OutputStream out = routeModel.getSocket().getOutputStream();
            	 out.write(body);
            	 out.flush();
            }
        };
        routeModel.getChannelRec().basicConsume(routeModel.getRouteId(),true, consumer);
	}
	
	/**
	 * 从socket读取消息
	 * @param routeModel
	 * @throws Exception
	 */
	public void ReadSocket(RouteModel routeModel) throws Exception {
		InputStream in = routeModel.getSocket().getInputStream();
    	Thread thread = new Thread(new Runnable() {
    		

			@Override
			public void run() {
				while(true) {
					try {
						byte[] buf = new byte[1024];
						int len = -1;
						while((len = in.read(buf)) != -1) {
							routeModel.setTimeStrap(System.currentTimeMillis());
							byte[] body = new byte[len];
							System.arraycopy(buf,0,body,0,len);
							routeModel.getChannelSend().basicPublish("","tcpQueue1",null,body);
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}	
			}
    	});
    	thread.start();
    	SystemVal.routeModel.setThreadSocket(thread);
    }
	
	/**
	 * 发送控制命令
	 * @param routeModel
	 * @param message
	 */
	public void messageControl(RouteModel routeModel,String message) {
		try {
			routeModel.getChannelSend().basicPublish("",routeModel.getRouteId()+"2",null,message.getBytes("UTF-8"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
