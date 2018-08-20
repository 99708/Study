package com.xyq.pb;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscribe3{
	
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageConsumer consumer;
	
	public Subscribe3() {
		try {
			this.factory = new ActiveMQConnectionFactory("997", "123", "tcp://localhost:61616");
			this.connection = this.factory.createConnection();
			this.connection.start();
			this.session = this.connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			this.destination = this.session.createTopic("topic1");
			this.consumer = this.session.createConsumer(destination);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	class MyListener implements MessageListener{

		@Override
		public void onMessage(Message message) {
			if(message instanceof MapMessage) {
				try {
					System.out.println(message.toString());
					System.out.println(((MapMessage) message).getString("name"));
					System.out.println(((MapMessage) message).getInt("age"));
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void receiver() {
		try {
			this.consumer.setMessageListener(new MyListener());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Subscribe3 subscribe = new Subscribe3();
		subscribe.receiver();
	}

}
