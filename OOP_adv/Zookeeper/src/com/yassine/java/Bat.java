package com.yassine.java;

public class Bat extends Mammal{

	public Bat(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}
	public void fly() {
		System.out.println("a bat sound");
		setEnergyLevel(getEnergyLevel()-50);
	}
	public void eatHumns() {
		System.out.println("the so-well never mind");
		setEnergyLevel(getEnergyLevel()+25);
	}
	public void attackTown() {
		System.out.println("SOUND OF A TOWN");
		setEnergyLevel(getEnergyLevel()-100);
	}
	

}
