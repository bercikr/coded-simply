package com.codedsimply.simplejms;

import org.apache.log4j.Logger;

public abstract class GenericJaxbMsgConsumer<T> 
{
	protected static Logger log = Logger.getLogger(GenericJaxbMsgConsumer.class);
	
	public void handleMessage(Object in){
		processMessage((T)in);
	}
	
	public abstract void processMessage(T message);

}
