package com.yassine.java;



public class Calculator {
	private double results;
	private double operand1;
	private double operand2;
	private char operator;
	
	// Constructor
	public Calculator() {
		
	}

	// Getters
	public double getOperand1() {
		return operand1;
	}

	public double getOperand2() {
		return operand2;
	}
	
	public char getOperator() {
		return operator;
	}
	
	// Setters
	
	public void setResults(double results) {
		this.results = results;
	}

	public void setOperand1(double input) {
		this.operand1 = input;
	}

	
	public void setOperand2(double input) {
		this.operand2 = input;
	}


	public void setOperator(char input) {
		this.operator = input;
	}
	
	// Methods
	public void performOperation() {
		if(this.operator == '+') {
			results = (operand1) + (operand2);
		}
		if(this.operator == '-') {
			results = (operand1) - (operand2);
		}
	}
	
	public void getResults() {
		System.out.println(results);
	}
	
}