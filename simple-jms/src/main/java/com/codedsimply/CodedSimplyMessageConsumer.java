package com.codedsimply;

import com.codedsimply.simplejms.GenericJaxbMessageListener;

public class CodedSimplyMessageConsumer extends GenericJaxbMessageListener 
{
	
	public CodedSimplyMessageConsumer() {
		super(CodedSimplyTypes.getInstance().createUnMarshaller());
	}

}
