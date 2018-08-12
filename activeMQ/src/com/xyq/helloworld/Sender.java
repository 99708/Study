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
	
	public static void main(String[] args)throws Exception {
		
		//第一步 ： 建立ConnectionFactory 工厂对象，需要填入用户名密码，以及要连接的地址，
		//均使用默认即可，默认端口为：tcp://localhsot:61616
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER, 
				ActiveMQConnectionFactory.DEFAULT_PASSWORD, 
				"tcp://localhost:61616");

		//第二步：通过connectionFactory 工厂对象我们创建一个Connection连接，
		//并且调用Connection的Start方法开启连接 因为Connection默认关闭的
		Connection connection = factory.createConnection();
		connection.start();
		
		//第三步：通过Connection对象创建Session会话 ，用于接受消息，
		//参数配置1为是否启用事务，2为签收模式，一般我们都是自动签收
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		
		//第四步 ：通过Session创建Destination对象，指的是一个客户端用来指定生产消息目标和消费消息来源的对象，
		//在PTP模式中，Destination为称作Queue 
		Destination destination = session.createQueue("queue1");
		
		//第五步L我们需要通过Session 创建消息的发送和接收对象
		MessageProducer messageProducer = session.createProducer(destination);
		
		//第六步：我们可以使用MessageProducer的setDeliverMode方法为其设置持久化和非持久化
		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		//第七步：最后我们使用JMS的TextMessage形式的创建数据，并用messageProducer的send方法发送数据
		for(int i = 0; i <= 5; i++) {
			TextMessage msg = session.createTextMessage("我是消息" + i);
			messageProducer.send(msg);
			System.out.println("我发送的消息内容是：" + msg.getText());
		}
		
		if(connection != null) {
			connection.close();
		}
	}
}
