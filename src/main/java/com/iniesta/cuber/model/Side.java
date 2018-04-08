package com.iniesta.cuber.model;

import java.util.Arrays;

/**
 * The side has 9 positions, and a center color, the center position is going to
 * be the 4th position in the array.
 * 
 * ___________________ | | | | | 0 | 1 | 2 | |_____|_____|_____| | | | | | 3 | 4
 * | 5 | |_____|_____|_____| | | | | | 6 | 7 | 8 | |_____|_____|_____|
 *
 * @author antonio
 *
 */
public class Side {

	private int[] posR = new int[] {2,5,8};
	private int[] posL = new int[] {0,3,6};
	private int[] posU = new int[] {0,1,2};
	private int[] posD = new int[] {6,7,8};
	
	private Color center;
	private Color[] pieces = new Color[9];

	public Side(Color center) {
		this.center = center;
		for (int i = 0; i < pieces.length; i++) {
			this.pieces[i] = center;
		}
	}

	public Color getCenter() {
		return center;
	}

	public Color[] getPieces() {
		return pieces;
	}

	public boolean isSideSolved() {
		boolean solved = true;
		for (Color color : pieces) {
			solved = solved && (color == center);
		}
		return solved;
	}

	private Color[] getRow(int[] indexes) {
		return new Color[] {pieces[indexes[0]], pieces[indexes[1]], pieces[indexes[2]]};
	}
	
	private void setRow(Color[] row, int[] indexes) {
		for (int i = 0; i < indexes.length; i++) {
			pieces[indexes[i]] = row[i];
		}
	}
	
	public Color[] getRowR() {
		return new Color[] {pieces[2], pieces[5], pieces[8]};
	}
	
	public void setRowR(Color[] row) {
		pieces[2] = row[0];
		pieces[5] = row[1];
		pieces[8] = row[2];
	}
	
	public Color[] getRowL() {
		return new Color[] {pieces[0], pieces[3], pieces[6]};
	}
	
	public void setRowL(Color[] row) {
		pieces[0] = row[0];
		pieces[3] = row[1];
		pieces[6] = row[2];
	}
	
	public Color[] getRowU() {
		return new Color[] {pieces[0], pieces[1], pieces[2]};
	}
	
	public void setRowU(Color[] row) {
		pieces[0] = row[0];
		pieces[1] = row[1];
		pieces[2] = row[2];
	}
	public Color[] getRowD() {
		return new Color[] {pieces[6], pieces[7], pieces[8]};
	}
	
	public void setRowD(Color[] row) {
		pieces[6] = row[0];
		pieces[7] = row[1];
		pieces[8] = row[2];
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + Arrays.hashCode(pieces);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Side other = (Side) obj;
		if (center != other.center)
			return false;
		if (!Arrays.equals(pieces, other.pieces))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Side [center=" + center + ", pieces=" + Arrays.toString(pieces) + "]";
	}

}
