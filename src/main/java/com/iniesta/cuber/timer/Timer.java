package com.iniesta.cuber.timer;

import javafx.scene.input.KeyEvent;

public class Timer {

	private static Timer instance;
	private TimerContext tctx;
	
	private Timer(TimerContext tctx) {
		current = new IdleState();
		this.tctx = tctx;
	}

	public synchronized static Timer getInstance(TimerContext tctx) {
		if(instance==null) {
			instance = new Timer(tctx);
		}
		return instance;
	}
	
	private TimerState current;
	
	public void transition(KeyEvent event) {
		TimerState newState = current.transition(event, tctx);
		this.current = newState;
	}
}
