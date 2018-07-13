package com.accenture.Instagram;

public class Informacion {
	
	public  double value1;
	public  double value2;
	public  String operation;
	
	public Informacion() {
	}
		
	
	
	public Informacion(double value1, double value2, String operation) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.operation = operation;
	}

	public double getValue1() {
		return value1;
	}

	public void setValue1(double d) {
		this.value1 = d;
	}

	public double getValue2() {
		return value2;
	}

	public void setValue2(double d) {
		this.value2 = d;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

}
