package com.yassine.java;

public class Car {
	private int gas;
   //Constructor
	public Car() {
		
		this.gas = 10;
	}

	//Getters and Setters
	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}
	//DisplayAmountMETHODS
	public void status() {
		System.out.printf("Gas remaining: %d/10\n", this.gas);
	}

}
