package com.iniesta.cuber.model.rotate;

import com.iniesta.cuber.model.Color;
import com.iniesta.cuber.model.Cube;
import com.iniesta.cuber.model.Side;

public abstract class AbstractMovement {

	public abstract void apply(Cube input);

	public abstract void applyInverse(Cube input);

	void slideRU(Cube input) {
		Color[] toUp = input.getMain().getRowR();
		Color[] toMain = input.getD().getRowR();
		Color[] toBack = input.getU().getRowR();
		Color[] toDown = input.getB().getRowL();
		input.getMain().setRowR(toMain);
		input.getU().setRowR(toUp);
		input.getB().setRowL(toBack);
		input.getD().setRowR(toDown);
	}

	void slideRD(Cube input) {
		Color[] toDown = input.getMain().getRowR();
		Color[] toBack = input.getD().getRowR();
		Color[] toUp = input.getB().getRowL();
		Color[] toMain = input.getU().getRowR();
		input.getMain().setRowR(toMain);
		input.getU().setRowR(toUp);
		input.getB().setRowL(toBack);
		input.getD().setRowR(toDown);
	}
	
	void slideLU(Cube input) {
		Color[] toUp = input.getMain().getRowL();
		Color[] toMain = input.getD().getRowL();
		Color[] toBack = input.getU().getRowL();
		Color[] toDown = input.getB().getRowR();
		input.getMain().setRowL(toMain);
		input.getU().setRowL(toUp);
		input.getB().setRowR(toBack);
		input.getD().setRowL(toDown);
	}

	void slideLD(Cube input) {
		Color[] toDown = input.getMain().getRowL();
		Color[] toBack = input.getD().getRowL();
		Color[] toUp = input.getB().getRowR();
		Color[] toMain = input.getU().getRowL();
		input.getMain().setRowL(toMain);
		input.getU().setRowL(toUp);
		input.getB().setRowR(toBack);
		input.getD().setRowL(toDown);
	}
	
	void slideUL(Cube input) {
		Color[] toLeft = input.getMain().getRowU();
		Color[] toRight = input.getB().getRowU();
		Color[] toBack = input.getL().getRowU();
		Color[] toMain = input.getR().getRowU();
		input.getMain().setRowU(toMain);
		input.getL().setRowU(toLeft);
		input.getB().setRowU(toBack);
		input.getR().setRowU(toRight);
	}

	void slideUR(Cube input) {
		Color[] toLeft = input.getB().getRowU();
		Color[] toRight = input.getMain().getRowU();
		Color[] toBack = input.getR().getRowU();
		Color[] toMain = input.getL().getRowU();
		input.getMain().setRowU(toMain);
		input.getL().setRowU(toLeft);
		input.getB().setRowU(toBack);
		input.getR().setRowU(toRight);
	}

	void slideDL(Cube input) {
		Color[] toLeft = input.getMain().getRowD();
		Color[] toRight = input.getB().getRowD();
		Color[] toBack = input.getL().getRowD();
		Color[] toMain = input.getR().getRowD();
		input.getMain().setRowD(toMain);
		input.getL().setRowD(toLeft);
		input.getB().setRowD(toBack);
		input.getR().setRowD(toRight);
	}

	void slideDR(Cube input) {
		Color[] toLeft = input.getB().getRowD();
		Color[] toRight = input.getMain().getRowD();
		Color[] toBack = input.getR().getRowD();
		Color[] toMain = input.getL().getRowD();
		input.getMain().setRowD(toMain);
		input.getL().setRowD(toLeft);
		input.getB().setRowD(toBack);
		input.getR().setRowD(toRight);
	}
	
	void clockwise(Side side) {
		Color[] rowU = side.getRowU();
		Color[] rowD = side.getRowD();
		Color[] rowR = side.getRowR();
		Color[] rowL = side.getRowL();
		side.setRowR(rowU);
		side.setRowD(rowR);
		side.setRowL(rowD);
		side.setRowU(rowL);
	}

	void anticlockwise(Side side) {
		Color[] rowU = side.getRowU();
		Color[] rowD = side.getRowD();
		Color[] rowR = side.getRowR();
		Color[] rowL = side.getRowL();
		side.setRowR(rowD);
		side.setRowD(rowL);
		side.setRowL(rowU);
		side.setRowU(rowR);
	}
}
