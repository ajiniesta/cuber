package com.iniesta.cuber.manager.puzzles;

import java.util.Random;

import com.iniesta.cuber.manager.CuberException;
import com.iniesta.cuber.manager.Scramble;
import com.iniesta.cuber.scramble.PuzzlePrinterManager;

import javafx.scene.image.Image;
import puzzle.CubePuzzle;

public class Rubiks4 implements MyPuzzle {

	private CubePuzzle cb;
	private Random r;

	private PuzzlePrinterManager ppm = new PuzzlePrinterManager();
	private String name;

	public Rubiks4(String name) {
		this.name = name;
		cb = new CubePuzzle(4);
		r = new Random();
	}

	@Override
	public String type() {
		return "4x4x4";
	}

	@Override
	public String puzzleName() {
		return name;
	}

	@Override
	public Scramble getScramble() throws CuberException {
		String wcaScramble = cb.generateWcaScramble(r);
		Image img = ppm.drawImage(cb, wcaScramble);
		return new Scramble(wcaScramble, img);
	}

}
