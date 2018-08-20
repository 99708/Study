package com.xyq.pb;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {

	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageProducer producer;
	
	public Publisher() {
		
		try {
			this.factory = new ActiveMQConnectionFactory("997", "123", "tcp://localhost:61616");
			this.connection = this.factory.createConnection();
			this.connection.start();
			this.session = this.connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			this.destination = this.session.createTopic("topic1");
			this.producer = this.session.createProducer(null);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

	public Session getSession() {
		return session;
	}
	
	public void send1() {
		try {
			MapMessage msg = (MapMessage)this.session.createMapMessage();
			msg.setString("name", "z3");
			msg.setInt("age", 23);
			
			MapMessage msg2 = (MapMessage)this.session.createMapMessage();
			msg2.setString("name", "L4");
			msg2.setInt("age", 24);
			
			MapMessage msg3 = (MapMessage)this.session.createMapMessage();
			msg3.setString("name", "z6");
			msg3.setInt("age", 29);
			
			this.producer.send(this.destination, msg, DeliveryMode.NON_PERSISTENT, 3, 1000*60);
			this.producer.send(this.destination, msg2, DeliveryMode.NON_PERSISTENT, 6, 1000*60);
			this.producer.send(this.destination, msg3, DeliveryMode.NON_PERSISTENT, 9, 1000*60);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Publisher publisher = new Publisher();
		publisher.send1();
	}

}