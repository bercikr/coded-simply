package com.codedsimply;




import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import com.codedsimply.simple_jaxb.ApplicationMsg;
import com.codedsimply.simple_jaxb.ApplicationStartMsg;
import com.codedsimply.simple_jaxb.ProcessInfo;
import com.codedsimply.simplejms.SimpleJmsContext;

public class JmsContextTest extends TestCase
{
	static Logger log = Logger.getLogger(JmsContextTest.class);
	
	public void testSend(){
		JmsTemplate jt = SimpleJmsContext.getInstance().getJmsTemplate();
		
		assertNotNull(jt);
		
		ApplicationStartMsg asm = new ApplicationStartMsg();
		
		ProcessInfo pi = new ProcessInfo();
		pi.setHostname("notarealhost");
		
		ApplicationMsg am = new ApplicationMsg();
		
		am.setProcessInfo(pi);
		asm.setAppMsg(am);

		
		CodedSimplyMessageCreator<ApplicationStartMsg> mc = new CodedSimplyMessageCreator<ApplicationStartMsg>(asm);
		
		jt.send(mc);
		
	}
	
	public void testReceive() throws Exception {
		SimpleMessageListenerContainer smlc = SimpleJmsContext.getInstance().getListener();
		
		assertNotNull(smlc);
		
		smlc.start();
		
		Thread.sleep(1000);
		
		smlc.stop();
		
	}

}

