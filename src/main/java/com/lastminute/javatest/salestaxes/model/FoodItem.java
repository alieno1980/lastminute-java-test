package com.lastminute.javatest.salestaxes.model;

public class FoodItem extends ExemptTaxItem {
	
	public FoodItem(String name, float price, boolean isImported) {
		super();
		this.name = name;
		this.price = price;
		this.isImported = isImported;
	}
	
}
