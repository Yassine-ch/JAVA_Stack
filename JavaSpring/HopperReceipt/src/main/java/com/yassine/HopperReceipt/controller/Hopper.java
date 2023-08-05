package com.yassine.HopperReceipt.controller;

public class Hopper {
	 private String name;
	 private String itemName ;
	 private double price ;
	 private String description;
	 private  String vendor;
	 
	 
	 
	 
	 
	public Hopper(String name, String itemName, double price, String description, String vendor) {
		super();
		this.name = name;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.vendor = vendor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	 
}
