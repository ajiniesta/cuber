package com.iniesta.cuber;

import java.util.Arrays;
import java.util.Random;

import net.gnehzr.tnoodle.scrambles.InvalidScrambleException;
import net.gnehzr.tnoodle.svglite.Svg;
import puzzle.CubePuzzle;
import puzzle.CubePuzzle.CubeState;

public class TNoodleTest {

	public static void main(String[] args) throws InvalidScrambleException {
		CubePuzzle cp = new CubePuzzle(3);
		String[] scrambles = cp.generateScrambles(1);
		System.out.println(Arrays.toString(scrambles));
		String wcaScramble = cp.generateWcaScramble(new Random());
		System.out.println(wcaScramble);
		CubeState cubeState = cp.getSolvedState();
		System.out.println(cubeState.isSolved());
		System.out.println(cp.getShortName());
		Svg svg = cp.drawScramble(wcaScramble, cp.getDefaultColorScheme());
		System.out.println(svg);
	}
}
