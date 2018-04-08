package com.iniesta.cuber.model.rotate;

import com.iniesta.cuber.model.Cube;

public class Left extends AbstractMovement {

	@Override
	public void apply(Cube input) {
		slideRU(input);
		clockwise(input.getR());
	}

	@Override
	public void applyInverse(Cube input) {
		slideRD(input);
		anticlockwise(input.getR());
	}

}
