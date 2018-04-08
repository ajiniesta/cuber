package com.iniesta.cuber.controller;


import com.iniesta.cuber.callbacks.MyPuzzleListCell;
import com.iniesta.cuber.components.ChronometerComponent;
import com.iniesta.cuber.conf.ApplicationConfiguration;
import com.iniesta.cuber.manager.PuzzleLoader;
import com.iniesta.cuber.manager.PuzzleManager;
import com.iniesta.cuber.manager.ToBindElements;
import com.iniesta.cuber.manager.puzzles.MyPuzzle;
import com.iniesta.cuber.timer.Timer;
import com.iniesta.cuber.timer.TimerContext;
import com.iniesta.cuber.timer.TimerEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class MainWindowController {

	@FXML
	private VBox parent;
	
	@FXML
	private Label textScramble;

	@FXML
	private ImageView imageScramble;

	@FXML
	private ProgressIndicator progress;
	
//	@FXML
//	private Label labelTime;
	
	@FXML
    private LineChart<?, ?> chart;
	
	@FXML
	private ComboBox<MyPuzzle> comboBox;
	
	@FXML
	private HBox hboxTime;
	
	@FXML
	void onSelectPuzzle(ActionEvent event) {
		MyPuzzle selectedItem = comboBox.getSelectionModel().getSelectedItem();
		puzzleManager.selectPuzzle(selectedItem.puzzleName());
		loadPuzzle();
		System.out.println("Selecting... " + selectedItem);
	}
	
    @FXML
    void onParentKeyPressed(KeyEvent event) {
    	System.out.println("Key pressed...." + event.getCode());
    }

    @FXML
    void onParentKeyReleased(KeyEvent event) {
    	System.out.println("Key released...." + event.getCode());
    }

	ToBindElements bindable;
	
	PuzzleManager puzzleManager;
	
	ApplicationConfiguration appConf = ApplicationConfiguration.getInstance();
	
	ChronometerComponent chrono = new ChronometerComponent();	
	
	Timer timer = Timer.getInstance(new TimerContext(chrono, appConf, new TimerEvent() {		
		@Override
		public void action() {
			loadPuzzle();
		}
	}));
	
	@FXML
	void initialize() throws Exception {
		String style = "-fx-font: 50pt \"Arial\";-fx-text-fill:  orange;";
		chrono.setStyle(style);
		hboxTime.getChildren().add(chrono);
		parent.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            timer.transition(event);
        });
		parent.addEventFilter(KeyEvent.KEY_RELEASED, event->{
            timer.transition(event);
        });
		puzzleManager = PuzzleManager.getInstance();
//		comboBox.itemsProperty().bind(puzzleManager.puzzlesProperty());
		comboBox.setItems(puzzleManager.itemsPuzzle());
		comboBox.setCellFactory(new Callback<ListView<MyPuzzle>, ListCell<MyPuzzle>>() {
			@Override
			public ListCell<MyPuzzle> call(ListView<MyPuzzle> param) {				
				return new MyPuzzleListCell();
			}
		});
		comboBox.setButtonCell(new MyPuzzleListCell());
		comboBox.getSelectionModel().select(puzzleManager.getSelectedPuzzle());
		bindable = new ToBindElements(parent, progress);
		loadPuzzle();
	}

	private void loadPuzzle() {
		PuzzleLoader loader = new PuzzleLoader(puzzleManager.getSelectedName());
		PuzzleLoader.customsBindings(loader, textScramble, imageScramble, bindable);
		loader.start();
	}
	
	
}
