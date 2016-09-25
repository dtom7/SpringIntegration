package com.example.springintegration.main;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.example.springintegration.config.JMSConfig;

public class Demo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JMSConfig.class);

		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);

		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage("Test Message");
				return textMessage;
			}
		});

		ctx.close();

	}

}
