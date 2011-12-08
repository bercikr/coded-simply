package com.codedsimply;

import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.codedsimply.simple_jaxb.ApplicationMsg;
import com.codedsimply.simple_jaxb.ApplicationStartMsg;
import com.codedsimply.simple_jaxb.MsgInfo;
import com.codedsimply.simple_jaxb.ProcessInfo;

import junit.framework.TestCase;

public class TestMarshall extends TestCase
{
	static Logger log = Logger.getLogger(TestMarshall.class);

	public void testMarshallObject() throws Exception
	{
		ApplicationStartMsg asm = new ApplicationStartMsg();
		
		ApplicationMsg am = new ApplicationMsg();
		
		MsgInfo mi = MessageUtils.createMessageInfo();
		
		ProcessInfo pi = MessageUtils.createProcessInfo();
		
		
		am.setMsgInfo(mi);
		am.setProcessInfo(pi);
		
		asm.setAppMsg(am);
		
		Marshaller m = CodedSimplyTypes.getInstance().createMarshaller();
		
		StringResult sr = new StringResult();
		
		m.marshal(asm, sr);
		
		log.info(sr);
		
	}
	
}
