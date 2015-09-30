package com.lastminute.javatest;

import com.lastminute.javatest.salestaxes.factory.BookItemFactory;
import com.lastminute.javatest.salestaxes.factory.Client;
import com.lastminute.javatest.salestaxes.factory.FoodItemFactory;
import com.lastminute.javatest.salestaxes.factory.MedicalItemFactory;
import com.lastminute.javatest.salestaxes.factory.OtherItemFactory;
import com.lastminute.javatest.salestaxes.model.Item;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	
	public AppTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testCaseOne() {
		Client client = new Client();
		
		client.selectCategory(new BookItemFactory());
		Item item1 = client.createItem("book", 12.49f, false);
		assertEquals(12.49f, (item1.getPrice() + item1.getTaxAmount()));
		
		client.selectCategory(new OtherItemFactory());
		Item item2 = client.createItem("music CD", 14.99f, false);
		assertEquals(16.49f, (item2.getPrice() + item2.getTaxAmount()));
		
		client.selectCategory(new FoodItemFactory());
		Item item3 = client.createItem("chocolateBar", 0.85f, false);
		assertEquals(0.85f, (item3.getPrice() + item3.getTaxAmount()));
	}
	
	public void testCaseTwo() {
		Client client = new Client();
		
		client.selectCategory(new FoodItemFactory());
		Item item1 = client.createItem("box of chocolates", 10.00f, true);
		assertEquals(10.50f, (item1.getPrice() + item1.getTaxAmount()));
		
		client.selectCategory(new OtherItemFactory());
		Item item2 = client.createItem("bottle of perfume", 47.50f, true);
		assertEquals(54.65f, (item2.getPrice() + item2.getTaxAmount()));
	}
	
	public void testCaseThree() {
		Client client = new Client();
		
		client.selectCategory(new OtherItemFactory());
		Item item1 = client.createItem("bottle of perfume", 27.99f, true);
		assertEquals(32.19f, (item1.getPrice() + item1.getTaxAmount()));
		
		client.selectCategory(new OtherItemFactory());
		Item item2 = client.createItem("bottle of perfume", 18.99f, false);
		assertEquals(20.89f, (item2.getPrice() + item2.getTaxAmount()));
		
		client.selectCategory(new MedicalItemFactory());
		Item item3 = client.createItem("packet of headache pills", 9.75f, false);
		assertEquals(9.75f, (item3.getPrice() + item3.getTaxAmount()));
		
		client.selectCategory(new FoodItemFactory());
		Item item4 = client.createItem("box of chocolates", 11.25f, true);
		assertEquals(11.80f, (item4.getPrice() + item4.getTaxAmount()));
	}
}
