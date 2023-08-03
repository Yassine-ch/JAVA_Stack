package com.yassine.java;

public class Mammal {
	private int energyLevel;
//Constructor
	public Mammal(int energyLevel) {
		super();
		this.energyLevel = energyLevel;
	}
	//Getters & Setters

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	//Methods
	public void displayEnergy() {
		System.out.println("the animal's Energy is : " +getEnergyLevel());
	}

}
