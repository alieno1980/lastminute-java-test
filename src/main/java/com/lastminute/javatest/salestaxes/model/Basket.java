package com.lastminute.javatest.salestaxes.model;

import java.util.ArrayList;
import java.util.List;

import com.lastminute.javatest.common.Utils;

public class Basket implements Printable {
	
	private List<Item> items;
	
	public void addItem(Item item) {
		if (items == null)
			items = new ArrayList<Item>();
		
		items.add(item);
	}
	
	public void emptyBasket() {
		if (items != null)
			items.clear();
	}
	
	public void printDetails() {
		if (items == null || items.size() == 0) {
			System.out.println("The basket is empty!");
			return;
		}
		
		float totalTaxes = 0f;
		float totalPrice = 0f;
		
		for (int i=0;i<items.size();i++) {
			Item item = items.get(i);
			item.printDetails();
			totalTaxes += item.getTaxAmount();
			totalPrice += item.getPrice();
		}
			
		System.out.printf("Sales Taxes: %s\n", Utils.getFormattedDecimal("#.##", totalTaxes));
		System.out.printf("Total: %s\n", Utils.getFormattedDecimal("#.##", (totalPrice + totalTaxes)));	
	}
	
}
