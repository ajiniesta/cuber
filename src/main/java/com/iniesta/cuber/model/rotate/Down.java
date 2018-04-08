package com.iniesta.cuber.model.rotate;

import com.iniesta.cuber.model.Cube;

public class Down extends AbstractMovement {

	@Override
	public void apply(Cube input) {
		slideDL(input);
		clockwise(input.getD());
	}

	@Override
	public void applyInverse(Cube input) {
		slideDR(input);
		anticlockwise(input.getD());
	}

}
