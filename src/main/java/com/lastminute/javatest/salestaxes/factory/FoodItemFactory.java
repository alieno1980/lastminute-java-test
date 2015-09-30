package com.lastminute.javatest.salestaxes.factory;

import com.lastminute.javatest.salestaxes.model.FoodItem;
import com.lastminute.javatest.salestaxes.model.Item;

public class FoodItemFactory implements ItemFactory {

	public Item createItem(String name, float price, boolean isImported) {
		return new FoodItem(name, price, isImported);
	}

}
