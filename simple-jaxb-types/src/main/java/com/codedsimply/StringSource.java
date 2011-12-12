package com.codedsimply;

import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

public class StringSource extends StreamSource 
{
	public StringSource(String s) {
		super(new StringReader(s));
	}
}
