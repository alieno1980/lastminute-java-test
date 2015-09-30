package com.lastminute.javatest.salestaxes.factory;

import com.lastminute.javatest.salestaxes.model.Item;
import com.lastminute.javatest.salestaxes.model.OtherItem;

public class OtherItemFactory implements ItemFactory {
	
	public Item createItem(String name, float price, boolean isImported) {
		return new OtherItem(name, price, isImported);
	}

}
