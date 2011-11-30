package com.codedsimply.jobchain;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class ChainJobManagerTest extends TestCase
{
	public void testIt() throws Exception
	{
		ChainedJobManager mgr = new ChainedJobManager();
		
		mgr.addJob(new TestJob1());
		mgr.addJob(new TestJob2());
		mgr.addJob(new TestJob3());
		
		mgr.startJobs();
		
		Thread.sleep(1000);
		
		mgr.stopJobs();
	}
	
	
}

class TestJob1 implements ChainedJob
{
	static Logger log = Logger.getLogger(TestJob1.class);
	int i =0;
	public void execute() throws Exception {
		log.info("run number#  " + i++ +  " " + getClass().getSimpleName() );
		Thread.sleep(100);
	}
}

class TestJob2 implements ChainedJob
{
	static Logger log = Logger.getLogger(TestJob1.class);
	int i =0;
	public void execute() throws Exception {
		log.info("run number#  " + i++ +  " " +  getClass().getSimpleName() );
		Thread.sleep(100);
	}
}

class TestJob3 implements ChainedJob
{
	static Logger log = Logger.getLogger(TestJob1.class);
	int i =0;
	public void execute() throws Exception {
		log.info("run number#  " + i++ +  " " +  getClass().getSimpleName() );
		Thread.sleep(100);
	}
}
