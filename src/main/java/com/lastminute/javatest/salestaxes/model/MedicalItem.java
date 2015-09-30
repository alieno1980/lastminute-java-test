package com.lastminute.javatest.salestaxes.model;

public class MedicalItem extends ExemptTaxItem {
	
	public MedicalItem(String name, float price, boolean isImported) {
		super();
		this.name = name;
		this.price = price;
		this.isImported = isImported;
	}
	
}
