package com.iniesta.cuber.manager;

import java.util.HashMap;
import java.util.Map;

import com.iniesta.cuber.manager.puzzles.MyPuzzle;
import com.iniesta.cuber.manager.puzzles.Pyraminx;
import com.iniesta.cuber.manager.puzzles.Rubiks2;
import com.iniesta.cuber.manager.puzzles.Rubiks3;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PuzzleManager {

	private Map<String, MyPuzzle> puzzles;
	private String selected;
	private static PuzzleManager instance;

	ObservableList<MyPuzzle> items = FXCollections.emptyObservableList();
	ObservableValue<ObservableList<MyPuzzle>> itemsProperty = new ReadOnlyListWrapper<>(items);

	private PuzzleManager() {
		// Retrieve all the puzzles.... from a DDBB, now just put it in this list
		puzzles = new HashMap<>();
		puzzles.put("Dayan Panshi", new Rubiks3("Dayan Panshi"));
		puzzles.put("Sengshou Gem", new Rubiks2("Sengshou Gem"));
		puzzles.put("Pyra", new Pyraminx("Pyra"));
		selected = "Pyra";
		items = FXCollections.observableArrayList(puzzles.values());
	}

	public synchronized static PuzzleManager getInstance() {
		if (instance == null) {
			instance = new PuzzleManager();
		}
		return instance;
	}

	public MyPuzzle getSelectedPuzzle() {
		return puzzles.get(selected);
	}

	public void selectPuzzle(String newPuzzle) {
		this.selected = newPuzzle;
	}

	public String getSelectedName() {
		return this.selected;
	}

	public ObservableValue<? extends ObservableList<MyPuzzle>> puzzlesProperty() {
		return itemsProperty;
	}
	
	public ObservableList<MyPuzzle> itemsPuzzle(){
		return items;
	}

}
