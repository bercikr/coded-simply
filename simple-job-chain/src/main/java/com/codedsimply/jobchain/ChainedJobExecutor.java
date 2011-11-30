package com.codedsimply.jobchain;

import org.apache.log4j.Logger;



public class ChainedJobExecutor 
{
	private ChainedJob job;
	private Thread jobThread;
	volatile boolean running=false;
	static Logger log = Logger.getLogger(ChainedJobExecutor.class);
	
	public ChainedJobExecutor(ChainedJob job) {
		this.job = job;
	}
	
	public void startJob(){
		log.info("starting job of type: " + job.getClass().getCanonicalName());
		running=true;
		jobThread = new Thread(new JobRunner(job, this));
		jobThread.start();
	}
	
	public void stopJob() throws Exception {
		running=false;
		jobThread.join();
		log.info("stopped job: " + job.getClass().getCanonicalName());
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	
}

class JobRunner implements Runnable{
	ChainedJob job;
	ChainedJobExecutor executor;
	static Logger log = Logger.getLogger(JobRunner.class);
	
	public JobRunner(ChainedJob job, ChainedJobExecutor executor) {
		super();
		this.job = job;
		this.executor = executor;
	}


	public void run() {
		while(executor.isRunning()){
			try {
				job.execute();
			} catch (Exception e) {
				log.error("error running job: ", e);
			}
		}
		
	}
	
	
}