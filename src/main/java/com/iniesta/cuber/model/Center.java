package com.iniesta.cuber.model;

public class Center extends Piece {

	public Center(Color color) {
		super();
		this.centerColor = color;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centerColor == null) ? 0 : centerColor.hashCode());
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
		Center other = (Center) obj;
		if (centerColor != other.centerColor)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Center [color=" + centerColor + "]";
	}
	
}
