package depaul.edu.Tests;

import depaul.edu.Item.*;

public class ItemTests {

	public static void main(String[] args) {
		
		//ac992605-d7e8-3bfe-87f9-9289b34b862a
		IAbstractItem item1 = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Beginner Violin", 800.0);
		System.out.println(item1.toString());
	
		//beb7b5e7-9511-3e31-9fd2-8bfa51f119e1
		IAbstractItem item2 = ItemFactory.createProduct(ItemType.VIOLIN, "Shar", "Intermediate Violin", 5000.0);
		System.out.println(item2.toString());
		
		IAbstractItem item3 = ItemFactory.createProduct(ItemType.VIOLIN, "Benjamin Ruth", "Professional Violin", 25500.0);
		System.out.println(item3.toString());
		
		IAbstractItem item4 = ItemFactory.createProduct(ItemType.PIANO, "Yamaha", "Digital Piano", 749.99);
		System.out.println(item4.toString());
		
		IAbstractItem item5 = ItemFactory.createProduct(ItemType.PIANO, "Baldwin", "Upright Piano", 13425.0);
		System.out.println(item5.toString());
		
		IAbstractItem item6 = ItemFactory.createProduct(ItemType.PIANO, "Steinway", "Grand Piano", 119400.0);
		System.out.println(item6.toString());
	}

}
