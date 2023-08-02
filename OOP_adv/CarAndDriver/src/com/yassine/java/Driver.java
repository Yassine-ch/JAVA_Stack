package com.yassine.java;

public class Driver extends Car {
	//CONSTRUCTOR_TO_GET_THE_CAR_CONSTRUCTOR
	public Driver() {
		super();
	}
//Methods
    public void drive() {
        
       setGas(getGas()-1);
    }

    public void useBoosters() {
    	setGas(getGas()-3);
    }

    public void refuel() {
    	setGas(getGas()+2); 
    }

}
