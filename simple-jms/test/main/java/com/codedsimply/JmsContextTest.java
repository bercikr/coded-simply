package com.codedsimply;




import junit.framework.TestCase;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import com.codedsimply.simple_jaxb.ApplicationStartMsg;

public class JmsContextTest extends TestCase
{
	static Logger log = Logger.getLogger(JmsContextTest.class);
	
	public void testJms(){
		JmsTemplate jt = SimpleJmsContext.getInstance().getJmsTemplate();
		
		assertNotNull(jt);
		
		ApplicationStartMsg msg = new ApplicationStartMsg();
		
		CodedSimplyMessageCreator<ApplicationStartMsg> mc = new CodedSimplyMessageCreator<ApplicationStartMsg>(msg);
		
		jt.send(mc);
		
	}

}

