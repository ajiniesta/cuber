package com.iniesta.cuber.conf;

public class ApplicationConfiguration {

	private static ApplicationConfiguration instance;
	
	private ApplicationConfiguration() {
		
	}
	
	public synchronized static ApplicationConfiguration getInstance() {
		if(instance==null) {
			instance = new ApplicationConfiguration();
		}
		return instance;
	}

	public boolean isInspectionTime() {
		return true;
	}
}
