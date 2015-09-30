package com.lastminute.javatest.salestaxes;

import com.lastminute.javatest.salestaxes.factory.BookItemFactory;
import com.lastminute.javatest.salestaxes.factory.FactoryManager;
import com.lastminute.javatest.salestaxes.factory.FoodItemFactory;
import com.lastminute.javatest.salestaxes.factory.MedicalItemFactory;
import com.lastminute.javatest.salestaxes.factory.OtherItemFactory;
import com.lastminute.javatest.salestaxes.model.Basket;

public class App {
	public static void main(String[] args) {
		
		FactoryManager factoryManager = new FactoryManager();
		Basket basket = new Basket();
		
		factoryManager.selectCategory(new BookItemFactory());
		basket.addItem(factoryManager.createItem("book", 12.49f, false));
		factoryManager.selectCategory(new OtherItemFactory());
		basket.addItem(factoryManager.createItem("music CD", 14.99f, false));
		factoryManager.selectCategory(new FoodItemFactory());
		basket.addItem(factoryManager.createItem("chocolateBar", 0.85f, false));
		
		basket.printDetails();
		basket.emptyBasket();
		
		System.out.println("");
		
		factoryManager.selectCategory(new FoodItemFactory());
		basket.addItem(factoryManager.createItem("box of chocolates", 10.00f, true));
		factoryManager.selectCategory(new OtherItemFactory());
		basket.addItem(factoryManager.createItem("bottle of perfume", 47.50f, true));
		
		basket.printDetails();
		basket.emptyBasket();
		
		System.out.println("");
		
		factoryManager.selectCategory(new OtherItemFactory());
		basket.addItem(factoryManager.createItem("bottle of perfume", 27.99f, true));
		factoryManager.selectCategory(new OtherItemFactory());
		basket.addItem(factoryManager.createItem("bottle of perfume", 18.99f, false));
		factoryManager.selectCategory(new MedicalItemFactory());
		basket.addItem(factoryManager.createItem("packet of headache pills", 9.75f, false));
		factoryManager.selectCategory(new FoodItemFactory());
		basket.addItem(factoryManager.createItem("box of chocolates", 11.25f, true));
		
		basket.printDetails();
	}
}
