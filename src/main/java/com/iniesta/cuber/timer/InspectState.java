package com.iniesta.cuber.timer;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InspectState extends TimerState {

	private long starting;

	public InspectState() {
		System.out.println("Welcome to starting state");
		starting = System.currentTimeMillis();
	}
	
	@Override
	TimerState transition(KeyEvent event, TimerContext tctx) {
		if (event.getCode() == KeyCode.SPACE) {
			long millis = System.currentTimeMillis()-starting;
			if(KeyEvent.KEY_RELEASED.equals(event.getEventType())) {
				tctx.getChrono().reset();
				tctx.getChrono().play();
				return new TimingState();
			} else {
				return this;
			}
		}else {
			return new IdleState();
		}
	}

}
