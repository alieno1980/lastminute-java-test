package com.lastminute.javatest.salestaxes.model;

public class BookItem extends ExemptTaxItem {
	
	public BookItem(String name, float price, boolean isImported) {
		super();
		this.name = name;
		this.price = price;
		this.isImported = isImported;
	}
	
}
