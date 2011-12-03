package com.codedsimply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;

import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class WebUtils 
{
	
	public static WebForm getFormByAction(WebResponse wc, String actionName) throws Exception 
	{
		for(WebForm form : wc.getForms()){
			if(actionName.equals(form.getAction()))
				return form;
		}
		return null;
	}
	
	public static void writeResp(WebResponse wr, String name) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(new File(name));
		IOUtils.copy(new StringReader(wr.getText()), fos);
		fos.close();
	}

}


