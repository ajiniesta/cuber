package com.iniesta.cuber.timer;

import javafx.scene.input.KeyEvent;

public abstract class TimerState {

	abstract TimerState transition(KeyEvent event, TimerContext tctx);
}
