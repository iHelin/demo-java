package com.ihelin.effective;

public class Elvis {

	public static final Elvis INSTANCE = new Elvis();

	private Elvis() {

	}

	public static Elvis getInstance() {
		return INSTANCE;
	}

	public Object readResolve() {
		return INSTANCE;
	}

	public void leaveTheBuilding() {

	}

}
