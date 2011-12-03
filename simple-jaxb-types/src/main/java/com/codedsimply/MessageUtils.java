package com.codedsimply;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.codedsimply.simple_jaxb.MsgInfo;
import com.codedsimply.simple_jaxb.ProcessInfo;

public class MessageUtils 
{
	static Logger log = Logger.getLogger(MessageUtils.class);
	
	public static MsgInfo createMessageInfo()
	{
		MsgInfo mi = new MsgInfo();
		
		XMLGregorianCalendar xmlTime = null;;
		try {
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new Date());
			xmlTime = dtf.newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			log.error("error creating xmltime: ", e);
		}
		
		mi.setMsgId(UUID.randomUUID().toString());
		mi.setTimeSent(xmlTime);
		
		return mi;
		
	}
	
	public static ProcessInfo createProcessInfo()
	{
		ProcessInfo pi = new ProcessInfo();
	
		pi.setHostname("yada");
		pi.setPid("there is a way to get this");
		pi.setOs("Leeenux");
		pi.setPort("Port of Bengal");
		pi.setVersion("1 dot O");
		
		return pi;
	}

}
