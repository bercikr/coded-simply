package org.codedsimply.webhacks.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.log4j.Logger;
import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EncodeController implements Controller
{

	static Logger log = Logger.getLogger(EncodeController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception 
	{
		String encodeUrl = req.getParameter("url");
		URL url = new URL(encodeUrl);
		BufferedInputStream bis = null;
		Base64OutputStream b6os = null;
		try{
			URLConnection urlc = url.openConnection();
			bis = new BufferedInputStream(urlc.getInputStream());
			b6os = new Base64OutputStream(resp.getOutputStream());
			byte[] buffer = new byte[2048];
			int bytesRead=0;
			while((bytesRead = bis.read(buffer))!=-1){
				b6os.write(buffer, 0, bytesRead);
			}
		}finally{
			bis.close();
			b6os.flush();
			b6os.close();
		}

		return null;
		
	}
	
	

}
