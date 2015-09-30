package com.lastminute.javatest;

import com.lastminute.javatest.salestaxes.factory.BookItemFactory;
import com.lastminute.javatest.salestaxes.factory.FactoryManager;
import com.lastminute.javatest.salestaxes.factory.FoodItemFactory;
import com.lastminute.javatest.salestaxes.factory.MedicalItemFactory;
import com.lastminute.javatest.salestaxes.factory.OtherItemFactory;
import com.lastminute.javatest.salestaxes.model.Basket;
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
		FactoryManager factoryManager = new FactoryManager();
		
		factoryManager.selectCategory(new BookItemFactory());
		Item item1 = factoryManager.createItem("book", 12.49f, false);
		assertEquals(12.49f, (item1.getPrice() + item1.getTaxAmount()));
		
		factoryManager.selectCategory(new OtherItemFactory());
		Item item2 = factoryManager.createItem("music CD", 14.99f, false);
		assertEquals(16.49f, (item2.getPrice() + item2.getTaxAmount()));
		
		factoryManager.selectCategory(new FoodItemFactory());
		Item item3 = factoryManager.createItem("chocolateBar", 0.85f, false);
		assertEquals(0.85f, (item3.getPrice() + item3.getTaxAmount()));
		
		Basket basket = new Basket();
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		
		assertEquals(1.50f, basket.getSalesTaxes());
		assertEquals(29.83f, basket.getTotal());
	}
	
	public void testCaseTwo() {
		FactoryManager factoryManager = new FactoryManager();
		
		factoryManager.selectCategory(new FoodItemFactory());
		Item item1 = factoryManager.createItem("box of chocolates", 10.00f, true);
		assertEquals(10.50f, (item1.getPrice() + item1.getTaxAmount()));
		
		factoryManager.selectCategory(new OtherItemFactory());
		Item item2 = factoryManager.createItem("bottle of perfume", 47.50f, true);
		assertEquals(54.65f, (item2.getPrice() + item2.getTaxAmount()));
		
		Basket basket = new Basket();
		basket.addItem(item1);
		basket.addItem(item2);
		
		assertEquals(7.65f, basket.getSalesTaxes());
		assertEquals(65.15f, basket.getTotal());
	}
	
	public void testCaseThree() {
		FactoryManager factoryManager = new FactoryManager();
		
		factoryManager.selectCategory(new OtherItemFactory());
		Item item1 = factoryManager.createItem("bottle of perfume", 27.99f, true);
		assertEquals(32.19f, (item1.getPrice() + item1.getTaxAmount()));
		
		factoryManager.selectCategory(new OtherItemFactory());
		Item item2 = factoryManager.createItem("bottle of perfume", 18.99f, false);
		assertEquals(20.89f, (item2.getPrice() + item2.getTaxAmount()));
		
		factoryManager.selectCategory(new MedicalItemFactory());
		Item item3 = factoryManager.createItem("packet of headache pills", 9.75f, false);
		assertEquals(9.75f, (item3.getPrice() + item3.getTaxAmount()));
		
		factoryManager.selectCategory(new FoodItemFactory());
		Item item4 = factoryManager.createItem("box of chocolates", 11.25f, true);
		assertEquals(11.85f, (item4.getPrice() + item4.getTaxAmount()));
		
		Basket basket = new Basket();
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		basket.addItem(item4);
		
		assertEquals(6.70f, basket.getSalesTaxes());
		assertEquals(74.68f, basket.getTotal());
	}
}
