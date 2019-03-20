package com.mx.api.test.loggerTest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface QueueListener{
	String value();
}

class SystemVal{
	public static Map<String,BlockingQueue<String>> map = new HashMap<String,BlockingQueue<String>>();
}


class QueueHandler{
	@QueueListener("queue1")
	public void queue1(String str) {
		System.out.println(str);
	}
	@QueueListener("queue2")
	public void queue2(String str) {
		System.out.println(str);
	}
}

class QueueExc{
	private QueueHandler handler;
	public void setHandler(QueueHandler handler) {
		this.handler = handler;
	}

	public void init() {
		Class clazz = handler.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method:methods) {
			QueueListener listener = method.getDeclaredAnnotation(QueueListener.class);
			if(listener != null) {
				String queueName = listener.value();
				if(!SystemVal.map.containsKey(queueName)) {
					SystemVal.map.put(queueName,new LinkedBlockingQueue<String>(10));
				}
				new Thread(()->{
					BlockingQueue<String> queue = SystemVal.map.get(queueName);
					while(true) {
						try {
							String data  = queue.poll(6,TimeUnit.SECONDS);	
							method.invoke(handler,data);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		}
	}
}

public class Test14 {
	
	public static void main(String args[]) {
		QueueHandler handler = new QueueHandler();
		QueueExc queueExc = new QueueExc();
		queueExc.setHandler(handler);
		queueExc.init();
		SystemVal.map.get("queue2").add("hello queue2");
		SystemVal.map.get("queue1").add("hello queue1");
	}
}
