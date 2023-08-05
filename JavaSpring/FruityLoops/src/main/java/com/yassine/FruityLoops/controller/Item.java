package com.yassine.FruityLoops.controller;

public class Item {
	private String name;
	private double price;
	//Constructor
	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	
	  
	

}
