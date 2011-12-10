package com.codedsimply;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;


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
	
}