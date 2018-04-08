package com.iniesta.cuber.manager;

import javafx.scene.image.Image;

public class Scramble {

	private String wcaScramble;
	private Image img;

	public Scramble(String wcaScramble, Image img) {
		this.wcaScramble = wcaScramble;
		this.img = img;
	}

	public String getWcaScramble() {
		return wcaScramble;
	}

	public Image getImg() {
		return img;
	}

	@Override
	public String toString() {
		return "Scramble [wcaScramble=" + wcaScramble + "]";
	}

}
