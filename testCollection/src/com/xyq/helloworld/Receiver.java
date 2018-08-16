package com.xyq.helloworld;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver {
	public static void main(String[] args) throws Exception {
		//1.创建工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER, 
				ActiveMQConnectionFactory.DEFAULT_PASSWORD, 
				"tcp://localhost:61616");
		
		//2、创建connection
		Connection connection = factory.createConnection();
		connection.start();
		
		//3、创建session
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		
		//4、创建queue
		Destination destination = session.createQueue("queue1");
		
		//5、创建接收者
		MessageConsumer messageConsumer = session.createConsumer(destination);
		
		//6、消费消息
		while(true) {
			TextMessage msg = (TextMessage)messageConsumer.receive();
			if(msg == null) break;
			System.out.println("我消费的消息是" + msg.getText());
		}
		
		//7、释放资源
		if(connection != null) {
			connection.close();
		}
	}
}
