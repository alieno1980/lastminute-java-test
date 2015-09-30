package com.lastminute.javatest.salestaxes.factory;

import com.lastminute.javatest.salestaxes.model.Item;

public class Client {
	
	ItemFactory itemCategory;
	
	public void selectCategory(ItemFactory f) {
		itemCategory = f;
	}
	
	public Item createItem(String name, float price, boolean isImported) {
		return itemCategory.createItem(name, price, isImported);
	}
	
}
