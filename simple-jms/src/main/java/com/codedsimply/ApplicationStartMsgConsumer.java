package com.codedsimply;

import com.codedsimply.simple_jaxb.ApplicationStartMsg;
import com.codedsimply.simplejms.GenericJaxbMsgConsumer;

public class ApplicationStartMsgConsumer extends GenericJaxbMsgConsumer<ApplicationStartMsg>
{

	@Override
	public void processMessage(ApplicationStartMsg message) {
		log.info("received startup message from: " + message.getAppMsg().getProcessInfo().getHostname());
		
	}
	
	

}
