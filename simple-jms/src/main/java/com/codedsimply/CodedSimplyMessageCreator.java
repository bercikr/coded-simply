package com.codedsimply;

import com.codedsimply.simplejms.GenericMessageCreator;


public class CodedSimplyMessageCreator<T> extends GenericMessageCreator<T>
{

	public CodedSimplyMessageCreator(T message){
		super(message, CodedSimplyTypes.getInstance().createMarshaller());
	}
	
}
