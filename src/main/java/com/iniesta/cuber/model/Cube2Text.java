package com.iniesta.cuber.model;

public class Cube2Text {

	public String sideBySide(Cube cube) {
		String text = new String();
		Side[] sides = cube.getSides();
		for (int i = 0; i < sides.length; i++) {
			Side side = sides[i];
			text += String.format("_________________________%n");
			text += String.format("|%s\t|%s\t|%s\t|%n", side.getPieces()[0], side.getPieces()[1], side.getPieces()[2]);
			text += String.format("_________________________%n");
			text += String.format("|%s\t|%s\t|%s\t|%n", side.getPieces()[3], side.getPieces()[4], side.getPieces()[5]);
			text += String.format("_________________________%n");
			text += String.format("|%s\t|%s\t|%s\t|%n", side.getPieces()[6], side.getPieces()[7], side.getPieces()[8]);
			text += String.format("_________________________%n");
		}
		return text;
	}
}
