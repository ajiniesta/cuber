package com.iniesta.cuber.model.rotate;

import com.iniesta.cuber.model.Cube;

public class Right extends AbstractMovement {

	@Override
	public void apply(Cube input) {
		slideLU(input);
		clockwise(input.getL());
	}

	@Override
	public void applyInverse(Cube input) {
		slideLD(input);
		anticlockwise(input.getL());
	}

}
