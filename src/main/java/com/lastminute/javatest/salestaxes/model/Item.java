package com.lastminute.javatest.salestaxes.model;

import com.lastminute.javatest.common.Utils;

public abstract class Item implements Taxable, Printable {
	
	String name;
	float price;
	boolean isImported;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	public float getTaxAmount() {
		float tax = Taxable.STANDARD_TAX;
		if (isImported) tax += Taxable.IMPORT_TAX;
		return Utils.roundUpNearest005(price * (tax / 100f));
	}
	
	public void printDetails() {
		System.out.printf("1%s %s: %s\n", Utils.getStringIf(" imported", isImported()),
				getName(), Utils.getFormattedDecimal("#.##", (getPrice() + getTaxAmount())));
	}
	
}
