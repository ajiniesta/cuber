package com.iniesta.cuber.timer;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TimingState extends TimerState {

	private long start;

	public TimingState() {
		System.out.println("Welcome to Timing state");
		start = System.currentTimeMillis();
	}
	
	@Override
	TimerState transition(KeyEvent event, TimerContext tctx) {
		if (event.getCode() == KeyCode.SPACE) {
			long timeMillis = System.currentTimeMillis()-start;
			System.out.format("Time in millis: %s ms%n", timeMillis);
			tctx.getChrono().stop();
			tctx.getActionEvent().action();
			return new IdleState();
		}else {
			return this;
		}
	}

}
