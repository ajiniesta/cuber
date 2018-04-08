package com.iniesta.cuber.manager.puzzles;

import com.iniesta.cuber.manager.CuberException;
import com.iniesta.cuber.manager.Scramble;

import javafx.scene.image.Image;

public interface MyPuzzle {

	String type();
	
	String puzzleName();
	
	Scramble getScramble() throws CuberException;
		
}
