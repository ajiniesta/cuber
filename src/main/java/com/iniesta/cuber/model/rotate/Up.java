package com.iniesta.cuber.model.rotate;

import com.iniesta.cuber.model.Cube;

public class Up extends AbstractMovement {

	@Override
	public void apply(Cube input) {
		slideUL(input);
		clockwise(input.getU());
	}

	@Override
	public void applyInverse(Cube input) {
		slideUR(input);
		anticlockwise(input.getU());
	}

}
