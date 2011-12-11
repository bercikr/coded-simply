package com.codedsimply;

public class CodedSimplyMessageCreator<T> extends GenericMessageCreator<T>
{

	public CodedSimplyMessageCreator(T message){
		super(message, CodedSimplyTypes.getInstance().createMarshaller());
	}
	
}
