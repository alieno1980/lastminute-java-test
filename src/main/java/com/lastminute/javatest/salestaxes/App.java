package com.lastminute.javatest.salestaxes;

import com.lastminute.javatest.salestaxes.factory.BookItemFactory;
import com.lastminute.javatest.salestaxes.factory.Client;
import com.lastminute.javatest.salestaxes.factory.FoodItemFactory;
import com.lastminute.javatest.salestaxes.factory.MedicalItemFactory;
import com.lastminute.javatest.salestaxes.factory.OtherItemFactory;
import com.lastminute.javatest.salestaxes.model.Basket;

public class App {
	public static void main(String[] args) {
		
		Basket basket = new Basket();
		Client client = new Client();
		
		client.selectCategory(new BookItemFactory());
		basket.addItem(client.createItem("book", 12.49f, false));
		client.selectCategory(new OtherItemFactory());
		basket.addItem(client.createItem("music CD", 14.99f, false));
		client.selectCategory(new FoodItemFactory());
		basket.addItem(client.createItem("chocolateBar", 0.85f, false));
		
		basket.printDetails();
		basket.emptyBasket();
		
		System.out.println("");
		
		client.selectCategory(new FoodItemFactory());
		basket.addItem(client.createItem("box of chocolates", 10.00f, true));
		client.selectCategory(new OtherItemFactory());
		basket.addItem(client.createItem("bottle of perfume", 47.50f, true));
		
		basket.printDetails();
		basket.emptyBasket();
		
		System.out.println("");
		
		client.selectCategory(new OtherItemFactory());
		basket.addItem(client.createItem("bottle of perfume", 27.99f, true));
		client.selectCategory(new OtherItemFactory());
		basket.addItem(client.createItem("bottle of perfume", 18.99f, false));
		client.selectCategory(new MedicalItemFactory());
		basket.addItem(client.createItem("packet of headache pills", 9.75f, false));
		client.selectCategory(new FoodItemFactory());
		basket.addItem(client.createItem("box of chocolates", 11.25f, true));
		
		basket.printDetails();
	}
}
