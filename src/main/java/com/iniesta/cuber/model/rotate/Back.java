package com.iniesta.cuber.model.rotate;

import com.iniesta.cuber.model.Color;
import com.iniesta.cuber.model.Cube;

public class Back extends AbstractMovement {

	@Override
	public void apply(Cube input) {
		
		Color[] toLeft = input.getU().getRowU();
		Color[] toDown = input.getL().getRowL();
		Color[] toRight = input.getD().getRowD();
		Color[] toUp = input.getR().getRowR();
		
		input.getL().setRowL(toLeft);
		input.getD().setRowD(toDown);
		input.getR().setRowR(toRight);
		input.getU().setRowU(toUp);
		clockwise(input.getB());
	}

	@Override
	public void applyInverse(Cube input) {
		Color[] toRight = input.getU().getRowU();
		Color[] toDown = input.getR().getRowR();
		Color[] toLeft = input.getD().getRowD();
		Color[] toUp = input.getL().getRowL();
		input.getL().setRowL(toLeft);
		input.getD().setRowD(toDown);
		input.getR().setRowR(toRight);
		input.getU().setRowU(toUp);
		anticlockwise(input.getB());
	}

}
