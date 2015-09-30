package com.lastminute.javatest.salestaxes.factory;

import com.lastminute.javatest.salestaxes.model.Item;
import com.lastminute.javatest.salestaxes.model.MedicalItem;

public class MedicalItemFactory implements ItemFactory {

	public Item createItem(String name, float price, boolean isImported) {
		return new MedicalItem(name, price, isImported);
	}

}
