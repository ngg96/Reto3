package com.accenture.Instagram;

import java.util.ArrayList;

public class Transformation {
	
	public String Operation;
	public String Value1;
	public String Value2;
	
	public Transformation() {
		
	}

	public Transformation(String operation, String value1, String value2) {
		super();
		Operation = operation;
		Value1 = value1;
		Value2 = value2;
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public String getValue1() {
		return Value1;
	}

	public void setValue1(String value1) {
		Value1 = value1;
	}

	public String getValue2() {
		return Value2;
	}

	public void setValue2(String value2) {
		Value2 = value2;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Value1 + " "+ Operation +" "+ Value2;
	}
}
