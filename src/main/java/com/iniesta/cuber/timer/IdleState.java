package com.iniesta.cuber.timer;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class IdleState extends TimerState {

	public IdleState() {
		System.out.println("Welcome to idle state");
	}
	
	@Override
	TimerState transition(KeyEvent event, TimerContext tctx) {		
		if (event.getCode() == KeyCode.SPACE && KeyEvent.KEY_PRESSED.equals(event.getEventType())) {
			return new InspectState();
		}else {
			return this;
		}
	}

}
