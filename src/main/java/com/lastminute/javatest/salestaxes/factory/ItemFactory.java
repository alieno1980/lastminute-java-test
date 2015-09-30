package com.lastminute.javatest.salestaxes.factory;

import com.lastminute.javatest.salestaxes.model.Item;

public interface ItemFactory {
	
	Item createItem(String name, float price, boolean isImported);
	
}
