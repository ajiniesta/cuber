package com.iniesta.cuber;

import com.iniesta.cuber.model.Cube;
import com.iniesta.cuber.model.Cube2Text;
import com.iniesta.cuber.model.rotate.Right;

public class CubePrinter {

	public static void main(String[] args) {
		Cube cube = new Cube();
		Cube2Text texter = new Cube2Text();
		System.out.println(texter.sideBySide(cube));
		System.out.println("Moving.....");
		Right right = new Right();
		right.apply(cube);
		System.out.println(texter.sideBySide(cube));
	}
}
