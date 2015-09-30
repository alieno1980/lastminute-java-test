package com.lastminute.javatest.salestaxes.model;

import java.util.ArrayList;
import java.util.List;

import com.lastminute.javatest.common.Utils;

public class Basket implements Printable {
	
	private List<Item> items;
	private float salesTaxes;
	private float total;
	
	public void addItem(Item item) {
		if (items == null)
			items = new ArrayList<Item>();
		items.add(item);
		
		incrementSalesTaxes(item.getTaxAmount());
		incrementTotal(item.getPrice() + item.getTaxAmount());
	}
	
	public void emptyBasket() {
		if (items != null)
			items.clear();
		
		salesTaxes = 0f;
		total = 0f;
	}
	
	private void incrementSalesTaxes(float itemTax) {
		salesTaxes += itemTax;
	}
	
	private void incrementTotal(float itemPriceTaxIncluded) {
		total += itemPriceTaxIncluded;
	}
	
	public float getSalesTaxes() {
		return salesTaxes;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void printDetails() {
		if (items == null || items.size() == 0) {
			System.out.println("The basket is empty!");
			return;
		}
		
		for (int i=0;i<items.size();i++)
			items.get(i).printDetails();
			
		System.out.printf("Sales Taxes: %s\n", Utils.getFormattedDecimal("#.##", salesTaxes));
		System.out.printf("Total: %s\n", Utils.getFormattedDecimal("#.##", total));	
	}
	
}
