package com.iniesta.cuber.callbacks;

import com.iniesta.cuber.manager.puzzles.MyPuzzle;

import javafx.scene.control.ListCell;

public class MyPuzzleListCell extends ListCell<MyPuzzle> {

	@Override
	protected void updateItem(MyPuzzle item, boolean empty) {
		super.updateItem(item, empty);
		if(item==null || empty) {
			setGraphic(null);
		}else {
			setText(item.type()+" - "+item.puzzleName());
		}
	}

}
