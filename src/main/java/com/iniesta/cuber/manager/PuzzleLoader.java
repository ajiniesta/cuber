package com.iniesta.cuber.manager;

import com.iniesta.cuber.manager.puzzles.MyPuzzle;

import javafx.beans.value.ChangeListener;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PuzzleLoader extends Service<Scramble> {

	PuzzleManager puzzleManager = PuzzleManager.getInstance();
	private String puzzleName;
	
	public PuzzleLoader(String puzzleName) {
		this.puzzleName = puzzleName;
		
	}
	
	@Override
	protected Task<Scramble> createTask() {
		return new Task<Scramble>() {
			@Override
			protected Scramble call() throws Exception {
				updateMessage("Generating scramble...");
				puzzleManager.selectPuzzle(puzzleName);
				MyPuzzle selectedPuzzle = puzzleManager.getSelectedPuzzle();
				updateMessage(selectedPuzzle.getScramble().getWcaScramble());
				return selectedPuzzle.getScramble();
			}
		};
	}

	public static void customsBindings(PuzzleLoader service, Label textScramble, ImageView imageScramble, ToBindElements bindable) {
		textScramble.textProperty().bind(service.messageProperty());
		service.stateProperty().addListener((ChangeListener<State>) (observable, oldValue, newValue) -> {
			if (newValue == State.SUCCEEDED) {
				imageScramble.setImage(service.getValue().getImg());
			}
		});
		bindable.bind(service);
	}
}
