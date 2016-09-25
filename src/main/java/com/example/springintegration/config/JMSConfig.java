package com.example.springintegration.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JMSConfig {

	@Bean
	public ActiveMQConnectionFactory activeMqConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		return activeMQConnectionFactory;
	}

	@Bean
	public CachingConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
		cachingConnectionFactory.setSessionCacheSize(10);
		cachingConnectionFactory.setCacheProducers(false);
		cachingConnectionFactory.setTargetConnectionFactory(activeMqConnectionFactory());
		return cachingConnectionFactory;
	}

	@Bean
	public ActiveMQQueue orderQueue() {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue("order.queue");
		return activeMQQueue;
	}
	
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestination(orderQueue());
        return template;
    }
}
