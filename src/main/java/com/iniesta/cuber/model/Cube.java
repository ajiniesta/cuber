package com.iniesta.cuber.model;

/**
 * The cube is going to be represented as an array of colors
 * @author antonio
 *
 */
public class Cube {

	private Side[] cube = new Side[6];
	
	/**
	 * Empty constructor returns a solved cube
	 */
	public Cube() {
		for (int i = 0; i < Color.values().length; i++) {
			cube[i] = new Side(Color.values()[i]);
		}
	}
	
	public boolean isSolved() {
		boolean solved = true;
		for (Side side : cube) {
			solved = solved && side.isSideSolved(); 
		}
		return solved;
	}
	
	public Side getMain() {
		return cube[0];
	}
	
	public Side getR() {
		return cube[4];
	}
	
	public Side getL() {
		return cube[5];
	}
	
	public Side getU() {
		return cube[2];
	}
	
	public Side getD() {
		return cube[3];
	}
	
	public Side getB() {
		return cube[1];
	}
	
	public Side[] getSides() {
		return cube;
	}
}
