package depaul.edu.CatalogueTests;

import depaul.edu.Catalogue.TCatalogue;
import depaul.edu.Item.IAbstractItem;
import depaul.edu.Item.ItemFactory;
import depaul.edu.Item.ItemType;

import java.util.ArrayList;
import java.io.File;

//D:\Programming\SE450 Object Oriented Software Development\Final Project\SE450_Final_Project\src\depaul\edu\Catalogue

public class CatalogueTest {

    public static void main(String[] args) {
		TCatalogue.getInstance();
		ArrayList<IAbstractItem> list = TCatalogue.getCatalogueAsList();

		for (IAbstractItem i : list) {
			System.out.println(i.toString());
			System.out.println();
		}

		System.out.println("*********************************");

		ArrayList<IAbstractItem> test1 = TCatalogue.findName("Viol");
		test1.forEach((item) -> System.out.println(item.toString() + "\n"));

		ArrayList<IAbstractItem> testList = createItems();
		TCatalogue.writeToFile(new File("src\\depaul\\edu\\Catalogue\\testCatalogue.csv"), testList ,true);
	}

	public static ArrayList<IAbstractItem> createItems() {
		ArrayList<IAbstractItem> list = new ArrayList<>();

		//System.out.println("VIOLIN TEST*******************************************");
		IAbstractItem item1a = ItemFactory.createProduct(ItemType.VIOLIN, "Medini", "Trash Violin", 55.95);
		list.add(item1a);

		IAbstractItem item1b = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Bad Violin", 89.99);
		list.add(item1b);
	
		IAbstractItem item2 = ItemFactory.createProduct(ItemType.VIOLIN, "Shar", "Student Violin", 850.0);
		list.add(item2);
		
		IAbstractItem item3a = ItemFactory.createProduct(ItemType.VIOLIN, "Joseph Curtin", "Professional Violin", 25500.0);
		list.add(item3a);

		IAbstractItem item3b = ItemFactory.createProduct(ItemType.VIOLIN, "Stradivarius", "Comte Cozio di Salabue Violin", 15000000.0);
		list.add(item3b);


		//System.out.println("PIANO TEST*******************************************");
		IAbstractItem item4 = ItemFactory.createProduct(ItemType.PIANO, "Kurzweil", "Digital Piano", 3999.99);
		list.add(item4);
		
		IAbstractItem item5 = ItemFactory.createProduct(ItemType.PIANO, "Yamaha", "Upright Piano", 15000.0);
		list.add(item5);

		IAbstractItem item6 = ItemFactory.createProduct(ItemType.PIANO, "Bosendorfer", "Grand Piano", 300000.0);
		list.add(item6);


		//System.out.println("VIOLA TEST*******************************************");
		IAbstractItem item7 = ItemFactory.createProduct(ItemType.VIOLA, "Shar", "Beginner Viola", 300.0);
		list.add(item7);

		IAbstractItem item8 = ItemFactory.createProduct(ItemType.VIOLA, "Yamaha", "Student Viola", 945.0);
		list.add(item8);

		IAbstractItem item9 = ItemFactory.createProduct(ItemType.VIOLA, "Benjamin Ruth", "Professional Viola", 18000.0);
		list.add(item9);

		
		//System.out.println("CELLO TEST*******************************************");
		IAbstractItem item10 = ItemFactory.createProduct(ItemType.CELLO, "Shar", "Beginner Cello", 899.0);
		list.add(item10);

		IAbstractItem item11 = ItemFactory.createProduct(ItemType.CELLO, "Frederich Harbin", "Intermediate Cello", 3000.0);
		list.add(item11);

		IAbstractItem item12 = ItemFactory.createProduct(ItemType.CELLO, "Francesco Toto", "Professional Cello", 25000.0);
		list.add(item12);

		
		//System.out.println("BASS TEST*******************************************");
		IAbstractItem item13 = ItemFactory.createProduct(ItemType.BASS, "StradViolin.com", "Beginner Bass", 1925.0);
		list.add(item13);

		IAbstractItem item14 = ItemFactory.createProduct(ItemType.BASS, "Shar", "Intermediate Bass", 2999.0);
		list.add(item14);

		IAbstractItem item15 = ItemFactory.createProduct(ItemType.BASS, "Steve Swan", "Professional Bass", 50000.0);
		list.add(item15);

		return list;
	}
}
