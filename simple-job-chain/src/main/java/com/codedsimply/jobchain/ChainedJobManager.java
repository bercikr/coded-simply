package com.codedsimply.jobchain;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class ChainedJobManager 
{
	static Logger log = Logger.getLogger(ChainedJobManager.class);
	private HashMap<ChainedJob, ChainedJobExecutor> jobMap = new HashMap<ChainedJob, ChainedJobExecutor>();
	
	public void addJob(ChainedJob job){
		jobMap.put(job, new ChainedJobExecutor(job));
	}
	
	public void startJobs(){
		for(ChainedJob nxt : jobMap.keySet()){
			ChainedJobExecutor exec = jobMap.get(nxt);
			exec.startJob();
		}
	}
	
	public void stopJobs(){
		for(ChainedJob nxt : jobMap.keySet()){
			ChainedJobExecutor exec = jobMap.get(nxt);
			try {
				exec.stopJob();
			} catch (Exception e) {
				log.error("error stopping job: ", e);
			}
		}
	}
	


}
