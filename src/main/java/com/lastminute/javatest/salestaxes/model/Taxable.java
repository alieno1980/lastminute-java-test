package com.lastminute.javatest.salestaxes.model;

public interface Taxable {
	
	static float STANDARD_TAX = 10;
	static float IMPORT_TAX = 5;
	
	public float getTaxAmount();
	
}
