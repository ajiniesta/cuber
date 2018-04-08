package com.iniesta.cuber.manager;

import javafx.concurrent.Service;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;

public class ToBindElements {

	private VBox container;
	private ProgressIndicator progress;

	public ToBindElements(VBox container, ProgressIndicator progress) {
		this.container = container;
		this.progress = progress;
	}

	public void bind(Service<?> service) {
		container.disableProperty().bind(service.runningProperty());
		progress.visibleProperty().bind(service.runningProperty());
	}
}
