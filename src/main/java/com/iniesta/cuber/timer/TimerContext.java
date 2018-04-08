package com.iniesta.cuber.timer;

import com.iniesta.cuber.components.ChronometerComponent;
import com.iniesta.cuber.conf.ApplicationConfiguration;
import com.iniesta.cuber.manager.PuzzleManager;

public class TimerContext {

	private ChronometerComponent chrono;
	private ApplicationConfiguration appConf;
	private TimerEvent actionEvent;

	public TimerContext(ChronometerComponent chrono, ApplicationConfiguration appConf, TimerEvent actionEvent) {
		this.chrono = chrono;
		this.appConf = appConf;
		this.actionEvent = actionEvent;
		// TODO Auto-generated constructor stub
	}

	public ChronometerComponent getChrono() {
		return chrono;
	}

	public ApplicationConfiguration getAppConf() {
		return appConf;
	}

	public TimerEvent getActionEvent() {
		return actionEvent;
	}

	
}
