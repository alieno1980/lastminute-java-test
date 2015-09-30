package com.lastminute.javatest.salestaxes.factory;

import com.lastminute.javatest.salestaxes.model.BookItem;
import com.lastminute.javatest.salestaxes.model.Item;

public class BookItemFactory implements ItemFactory {

	public Item createItem(String name, float price, boolean isImported) {
		return new BookItem(name, price, isImported);
	}

}
