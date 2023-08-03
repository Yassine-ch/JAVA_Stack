package com.yassine.java;

public class Gorilla extends Mammal{

	public Gorilla(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}
	public void throwSomeThihgs() {
		System.out.println("The Gorilla has throw somethings");
		setEnergyLevel(getEnergyLevel()-5);
		
	}
	public void eatBananas() {
		System.out.println(" The Gorilla is Good");
		setEnergyLevel(getEnergyLevel()+10);
		
	}
	public void climb() {
		System.out.println("");
		
		
	}

}
