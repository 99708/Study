package com.xyq.helloworld;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {
	public static void main(String[] args) throws Exception{
		
		//1.创建工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER, 
				ActiveMQConnectionFactory.DEFAULT_PASSWORD, 
				"tcp://localhost:61616");
		
		//2.创建connection
		Connection connection = factory.createConnection();
		connection.start();
		
		//3.创建session
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		
		//4、创建queue
		Destination destination = session.createQueue("queue1");
		
		//5、创建消息发送者
		MessageProducer mp = session.createProducer(destination);
		
		//6、设置持久化方式
		mp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		//7.生产和发送消息
		for(int i=0; i<5; i++) {
			TextMessage tm = session.createTextMessage("我是消息" + i);
			mp.send(tm);
			System.out.println("我发送消息：" + tm.getText());
		}
		
		//8.关闭connection
		if(connection != null) {
			connection.close();
		}
	}
}
