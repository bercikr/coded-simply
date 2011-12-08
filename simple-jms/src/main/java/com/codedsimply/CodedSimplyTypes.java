package com.codedsimply;


public class CodedSimplyTypes extends GenericJaxbContext
{
	
	private static String SIMPLE_TYPEs_PKG = "com.codedsimply.simple_jaxb";
	
	private static CodedSimplyTypes instance = null;
	
	private CodedSimplyTypes(){
		super(SIMPLE_TYPEs_PKG);
	}
	
	public static CodedSimplyTypes getInstance(){
		if(instance==null){
			instance = new CodedSimplyTypes();
		}
		return instance;
	}

}
