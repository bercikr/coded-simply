package com.codedsimply;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.springframework.jms.core.MessageCreator;

class GenericMessageCreator<T> implements MessageCreator
{
	static Logger log = Logger.getLogger(GenericMessageCreator.class);
	T sendMe;
	Marshaller marshaller;
	
	public GenericMessageCreator(T sendMe, Marshaller marshaller) {
		this.sendMe = sendMe;
		this.marshaller = marshaller;
	}

	public Message createMessage(Session session) throws JMSException {
		StringResult sr = new StringResult();
		try {
			marshaller.marshal(sendMe, sr);
			log.info(sr.toString());
		} catch (JAXBException e) {
			log.error("error marshalling message:", e);
			throw new JMSException("problem creating message, " + e.getMessage());
		}
		TextMessage tm = session.createTextMessage("string");
		return tm;
	}
	
	
	
}