package com.codedsimply;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

public class GenericJaxbContext 
{
	private JAXBContext jaxbContext = null;
	private String packageToUse;
	private ClassLoader classloader;
	static Logger log = Logger.getLogger(GenericJaxbContext.class);
	
	public GenericJaxbContext(String packageToUse) {
		this(packageToUse, ClassLoader.getSystemClassLoader());
	}
	
	public GenericJaxbContext(String packageToUse, ClassLoader classloader) {
		this.packageToUse = packageToUse;
		this.classloader = classloader;
		try {
			jaxbContext = JAXBContext.newInstance(packageToUse);
		} catch (JAXBException e) {
			log.error("error creating jaxb context: " , e);
		}
	}
	
	public Marshaller createMarshaller() {
		Marshaller m = null;
		
		try {
			m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (JAXBException e) {
			log.error("error creating jaxb marshaller: " , e);
		}
		
		return m;
	}
	
	public Unmarshaller createUnMarshaller(){
		Unmarshaller um = null;
		try {
			um = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			log.error("error creating jaxb unmarshaller: " , e);
		}
		return um;
	}
	
	public String getPackageToUse() {
		return packageToUse;
	}
	public void setPackageToUse(String packageToUse) {
		this.packageToUse = packageToUse;
	}
	public ClassLoader getClassloader() {
		return classloader;
	}
	public void setClassloader(ClassLoader classloader) {
		this.classloader = classloader;
	}
	
	
	
}
