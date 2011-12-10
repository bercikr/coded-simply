package com.codedsimply;



import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import com.codedsimply.SimpleJmsContext;

import junit.framework.TestCase;

public class JmsContextTest extends TestCase
{
	static Logger log = Logger.getLogger(JmsContextTest.class);
	
	public void testJms(){
		JmsTemplate jt = SimpleJmsContext.getInstance().getJmsTemplate();
		
		assertNotNull(jt);
	}

}
