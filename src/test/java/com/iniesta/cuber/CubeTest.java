package com.iniesta.cuber;

import org.junit.Assert;
import org.junit.Test;

import com.iniesta.cuber.model.Cube;
import com.iniesta.cuber.model.rotate.Back;
import com.iniesta.cuber.model.rotate.AbstractMovement;
import com.iniesta.cuber.model.rotate.Down;
import com.iniesta.cuber.model.rotate.Front;
import com.iniesta.cuber.model.rotate.Left;
import com.iniesta.cuber.model.rotate.Right;
import com.iniesta.cuber.model.rotate.Up;

public class CubeTest {

	@Test
	public void testInitialCube() {
		Cube cube = new Cube();
		Assert.assertTrue(cube.isSolved());
	}
	
	@Test
	public void testBasicMovemente() {
		Cube cube = new Cube();
		Right right = new Right();
		right.apply(cube);
		Assert.assertFalse(cube.isSolved());
		right.applyInverse(cube);
		Assert.assertTrue(cube.isSolved());
	}
	
	@Test
	public void testRoundRight() {
		Cube cube = new Cube();
		Right right = new Right();
		right.apply(cube);
		Assert.assertFalse(cube.isSolved());
		right.apply(cube);
		right.apply(cube);
		right.apply(cube);
		Assert.assertTrue(cube.isSolved());
	}
	
	@Test
	public void testFullRoundMovements() {
		Cube cube = new Cube();
		AbstractMovement[] rotates = new AbstractMovement[] {new Right(), new Left(), new Up(), new Down(), new Front(), new Back()};
		for (int i = 0; i < rotates.length; i++) {
			AbstractMovement movement = rotates[i];
			for (int j = 0; j < 4; j++) {
				movement.apply(cube);	
			}
			for (int j = 0; j < 4; j++) {
				movement.applyInverse(cube);	
			}
		}
		Assert.assertTrue(cube.isSolved());
	}
}
