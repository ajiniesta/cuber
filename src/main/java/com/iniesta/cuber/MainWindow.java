package com.iniesta.cuber;

import com.iniesta.cuber.controller.MainWindowController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainWindow.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.setWidth(800);
			primaryStage.setHeight(600);
			primaryStage.setTitle("Cube Timer FX");
//			primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("fxml/images/icon.png")));
			primaryStage.show();
		
	}
	
}
