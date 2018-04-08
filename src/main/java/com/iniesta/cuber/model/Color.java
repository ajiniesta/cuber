package com.iniesta.cuber.model;

public enum Color {
	WHITE, YELLOW, BLUE, GREEN, RED, ORANGE;
	
	public Color opposite(Color c) {
		Color o;
		switch (c) {
		case WHITE:
			o = YELLOW;
			break;
		case YELLOW:
			o = WHITE;
			break;
		case BLUE:
			o = GREEN;
			break;
		case GREEN:
			o = BLUE;
			break;
		case RED:
			o = ORANGE;
			break;
		case ORANGE:
			o = RED;
			break;
		default:
			o = c;
			break;
		}
		return o;
	}
}
