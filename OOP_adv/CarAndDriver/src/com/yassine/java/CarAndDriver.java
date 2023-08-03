package com.yassine.java;

public class CarAndDriver {
	public static void main(String []args) {
		Driver driver1 = new Driver();
		Driver driver2 = new Driver();
		driver1.status();
		driver1.drive();
		driver1.status();
		driver2.refuel();
		driver2.status();
		
	}

}
