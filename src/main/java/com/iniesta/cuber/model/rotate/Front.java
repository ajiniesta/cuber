package com.iniesta.cuber.model.rotate;

import com.iniesta.cuber.model.Color;
import com.iniesta.cuber.model.Cube;

public class Front extends AbstractMovement {

	@Override
	public void apply(Cube input) {
		Color[] toRight = input.getU().getRowD();
		Color[] toDown = input.getR().getRowL();
		Color[] toLeft = input.getD().getRowU();
		Color[] toUp = input.getL().getRowR();
		input.getL().setRowR(toLeft);
		input.getD().setRowU(toDown);
		input.getR().setRowL(toRight);
		input.getU().setRowD(toUp);
		clockwise(input.getMain());
	}

	@Override
	public void applyInverse(Cube input) {
		Color[] toLeft = input.getU().getRowD();
		Color[] toDown = input.getL().getRowR();
		Color[] toRight = input.getD().getRowU();
		Color[] toUp = input.getR().getRowL();
		input.getL().setRowR(toLeft);
		input.getD().setRowU(toDown);
		input.getR().setRowL(toRight);
		input.getU().setRowD(toUp);
		anticlockwise(input.getMain());
	}

}
