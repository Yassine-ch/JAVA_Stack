package com.yassine.java;

public class Program {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setOperand1(10.5);
		c.setOperand2(5.2);
		c.setOperator('+');
		c.performOperation();
		c.getResults();
		
	}

}