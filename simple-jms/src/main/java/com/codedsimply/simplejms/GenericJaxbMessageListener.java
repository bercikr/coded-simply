package com.codedsimply.simplejms;

import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.codedsimply.StringSource;

public class GenericJaxbMessageListener implements MessageListener
{

	protected Unmarshaller unmarshaller;
	Map<Class, GenericJaxbMsgConsumer> consumerMap;
	private static Logger log = Logger.getLogger(GenericJaxbMessageListener.class);
	
	public Map<Class, GenericJaxbMsgConsumer> getConsumerMap() {
		return consumerMap;
	}

	public void setConsumerMap(Map<Class, GenericJaxbMsgConsumer> consumerMap) {
		this.consumerMap = consumerMap;
	}

	public GenericJaxbMessageListener(Unmarshaller um) {
		unmarshaller = um;
	}
	
	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	@Override
	public void onMessage(Message msg) {
		TextMessage message = (TextMessage) msg;
		
		brokerMessage(message);
		
	}
	
	public void brokerMessage(TextMessage tm) 
	{
		String msgText = null;
		try {
			msgText = tm.getText();
			StringSource ss = new StringSource(msgText);
			Object obj = unmarshaller.unmarshal(ss);
			if(obj!=null){
				GenericJaxbMsgConsumer consumer = consumerMap.get(obj.getClass());
				if(consumer==null){
					log.warn("no handler for message: " +  msgText);
					return;
				}
				consumer.handleMessage(obj);
			}
		} catch (Exception e) {
			log.error("error processing message: " + msgText , e);
		}
	}

	
	
}
