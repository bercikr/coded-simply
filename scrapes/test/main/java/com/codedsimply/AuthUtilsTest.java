package com.codedsimply;


import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

import junit.framework.TestCase;

public class AuthUtilsTest extends TestCase
{
	static Logger log = Logger.getLogger(AuthUtilsTest.class);
	
	static String baseURL = "http://www.mp3fund.com/";
	
	public void testIt() throws Exception 
	{
		Properties p = new Properties();
		p.load(new FileInputStream("src/main/resources/login.properties"));
		String password = (String)p.get("password");
		
		WebConversation wc = new WebConversation();
		WebRequest wreq = new GetMethodWebRequest(baseURL + "/login.html");
		WebResponse wres = wc.getResource(wreq);
		
		WebForm wf = WebUtils.getFormByAction(wres, "/login.html");
		wf.setParameter("login", "rob.bercik@gmail.com");
		wf.setParameter("password", password);
		
		wres = wf.submit();
		
		for(int i=1; i <=136; i++){
			wreq = new GetMethodWebRequest(baseURL + "downloads.html?p="+i);
			wres = wc.getResource(wreq);
			
			WebLink[] links = wres.getLinks();
			log.info("processing page: " + i);
			for(WebLink link : links){
				if(!"Download".equals(link.getText()))
					continue;
				String url = link.getURLString();
				String clean = url.replaceAll(".*\\/", "");
				log.info(link.getText() + ": " + clean);
			}
			
		}

		
	}

}
