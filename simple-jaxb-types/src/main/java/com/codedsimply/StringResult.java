package com.codedsimply;

import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

public class StringResult extends StreamResult
{
	public StringResult() {
		super(new StringWriter());
	}
	
	@Override
	public String toString() {
		return getWriter().toString();
	}
}
