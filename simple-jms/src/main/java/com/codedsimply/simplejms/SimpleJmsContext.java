package com.codedsimply.simplejms;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;


public class SimpleJmsContext 
{
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jms-context.xml");
	
	private static SimpleJmsContext instance = new SimpleJmsContext();
	
	public JmsTemplate getJmsTemplate(){
		return context.getBean(JmsTemplate.class);
	}
	
	public static SimpleJmsContext getInstance(){
		return instance;
	}
	
	public SimpleMessageListenerContainer getListener(){
		SimpleMessageListenerContainer smlc= context.getBean(SimpleMessageListenerContainer.class);
		return smlc;
	}
	
}