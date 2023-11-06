package depaul.edu.Tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import depaul.edu.Item.IAbstractItem;
import depaul.edu.Item.ItemFactory;
import depaul.edu.Item.ItemType;

public class ItemTests {
	private static String testPath = "src\\depaul\\edu\\Catalogue\\testproducts.csv";

	public static void main(String[] args) {
		System.out.println("\n************************EQUALITY TESTS************************");
		System.out.println();
		equalityTests();

		System.out.println("\n************************TO STRING TEST************************");
		System.out.println("\nGenerating items...");
		System.out.println();
		ArrayList<IAbstractItem> list = createItems();
		for (IAbstractItem i : list) {
			System.out.println(i.toString());
			System.out.println(i.hashCode());
			System.out.println();
		}

		System.out.println("\n************************VIEW TEST************************");
		System.out.println();
		for (IAbstractItem i : list) {
			System.out.println(i.view());
		}		

		System.out.println("\n************************FILE WRITE TEST************************");
		for (IAbstractItem i : list) {
			writeToFile(testPath, i);
		}

		System.out.println("\n************************FILE READ TEST************************");
		readFile(testPath);
	}

	public static void equalityTests() {
		IAbstractItem itemA = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Bad Violin", 89.99);
		IAbstractItem itemB = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Bad Violin", 89.99);

		System.out.print("itemA.equals(itemA) == true : ");
		System.out.println(itemA.equals(itemA) == true);

		System.out.print("itemA.equals(itemB) : ");
		System.out.println(itemA.equals(itemB));

		System.out.print("itemB.equals(itemA) : ");
		System.out.println(itemB.equals(itemA));

		System.out.print("itemB.equals(itemB) == true : ");
		System.out.println(itemB.equals(itemB) == true);

		System.out.print("itemA.equals(null) : ");
		System.out.println(itemA.equals(null));

		System.out.print("itemB.equals(null) : ");
		System.out.println(itemB.equals(null));


		IAbstractItem itemC = ItemFactory.createProduct(ItemType.VIOLIN, "Shar", "Cool Violin", 5000.0);
		IAbstractItem itemD = ItemFactory.createProduct(ItemType.VIOLIN, "Benjamin Ruth", "Cool Violin", 5000.0);

		System.out.println();
		System.out.print("itemC.equals(itemC) == true : ");
		System.out.println(itemC.equals(itemC) == true);

		System.out.print("itemC.equals(itemD) : ");
		System.out.println(itemC.equals(itemD));

		System.out.print("itemD.equals(itemC) : ");
		System.out.println(itemD.equals(itemC));

		System.out.print("itemD.equals(itemD) == true : ");
		System.out.println(itemD.equals(itemD) == true);


		IAbstractItem itemE = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Dumb Violin", 109.99);
		IAbstractItem itemF = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Dumb Violin", 109.99);
		IAbstractItem itemG = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Dumb Violin", 109.99);

		System.out.println();
		System.out.print("itemE.equals(itemE) == true : ");
		System.out.println(itemE.equals(itemE) == true);

		System.out.print("itemE.equals(itemF) : ");
		System.out.println(itemE.equals(itemF));

		System.out.print("itemE.equals(itemG) : ");
		System.out.println(itemE.equals(itemG));

		System.out.println();
		System.out.print("itemF.equals(itemF)  == true : ");
		System.out.println(itemF.equals(itemF) == true);

		System.out.print("itemF.equals(itemE) : ");
		System.out.println(itemF.equals(itemE));

		System.out.print("itemF.equals(itemG) : ");
		System.out.println(itemF.equals(itemG));		
		
		System.out.println();
		System.out.print("itemG.equals(itemG)  == true : ");
		System.out.println(itemG.equals(itemG) == true);

		System.out.print("itemG.equals(itemE) : ");
		System.out.println(itemG.equals(itemE));

		System.out.print("itemG.equals(itemF) : ");
		System.out.println(itemG.equals(itemF));


		IAbstractItem itemH = ItemFactory.createProduct(ItemType.VIOLIN, "Shar", "Instrument", 2500.0);
		IAbstractItem itemI = ItemFactory.createProduct(ItemType.VIOLA, "Shar", "Instrument", 2500.0);

		// System.out.println();
		// System.out.println(itemH.toString());
		// System.out.println(itemH.hashCode());
		// System.out.println(itemI.toString());
		// System.out.println(itemI.hashCode());

		System.out.println();
		System.out.print("itemH.equals(itemH) == true : ");
		System.out.println(itemH.equals(itemH) == true);

		System.out.print("itemH.equals(itemI) : ");
		System.out.println(itemH.equals(itemI));

		System.out.print("itemI.equals(itemH) : ");
		System.out.println(itemI.equals(itemH));

		System.out.print("itemI.equals(itemI) == true : ");
		System.out.println(itemI.equals(itemI) == true);
	}

	public static ArrayList<IAbstractItem> createItems() {
		ArrayList<IAbstractItem> list = new ArrayList<>();

		//System.out.println("VIOLIN TEST*******************************************");
		IAbstractItem item1a = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Trash Violin", 99.95);
		list.add(item1a);

		IAbstractItem item1b = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Trash Violin", 99.95);
		list.add(item1b);
	
		IAbstractItem item2 = ItemFactory.createProduct(ItemType.VIOLIN, "Shar", "Student Violin", 900.0);
		list.add(item2);
		
		IAbstractItem item3 = ItemFactory.createProduct(ItemType.VIOLIN, "Benjamin Ruth", "Professional Violin", 25500.0);
		list.add(item3);


		//System.out.println("PIANO TEST*******************************************");
		IAbstractItem item4 = ItemFactory.createProduct(ItemType.PIANO, "Yamaha", "Digital Piano", 749.99);
		list.add(item4);
		
		IAbstractItem item5 = ItemFactory.createProduct(ItemType.PIANO, "Baldwin", "Upright Piano", 13425.0);
		list.add(item5);

		IAbstractItem item6 = ItemFactory.createProduct(ItemType.PIANO, "Steinway", "Grand Piano", 119400.0);
		list.add(item6);


		//System.out.println("VIOLA TEST*******************************************");
		IAbstractItem item7 = ItemFactory.createProduct(ItemType.VIOLA, "Shar", "Beginner Viola", 279.99);
		list.add(item7);

		IAbstractItem item8 = ItemFactory.createProduct(ItemType.VIOLA, "Yamaha", "Student Viola", 945.0);
		list.add(item8);

		IAbstractItem item9 = ItemFactory.createProduct(ItemType.VIOLA, "Thomas Oliver Croen", "Professional Viola", 14000.0);
		list.add(item9);

		
		//System.out.println("CELLO TEST*******************************************");
		IAbstractItem item10 = ItemFactory.createProduct(ItemType.CELLO, "Shar", "Beginner Cello", 899.0);
		list.add(item10);

		IAbstractItem item11 = ItemFactory.createProduct(ItemType.CELLO, "Frederich Harbin", "Intermediate Cello", 3100.0);
		list.add(item11);

		IAbstractItem item12 = ItemFactory.createProduct(ItemType.CELLO, "Thomas Hoyer", "Professional Cello", 20000.0);
		list.add(item12);

		
		//System.out.println("BASS TEST*******************************************");
		IAbstractItem item13 = ItemFactory.createProduct(ItemType.BASS, "StradViolin.com", "Beginner Bass", 1925.0);
		list.add(item13);

		IAbstractItem item14 = ItemFactory.createProduct(ItemType.BASS, "Shar", "Intermediate Bass", 2999.0);
		list.add(item14);

		IAbstractItem item15 = ItemFactory.createProduct(ItemType.BASS, "Steve Swan", "Professional Bass", 50000.0);
		list.add(item15);

		IAbstractItem item16 = ItemFactory.createProduct(ItemType.BASS, "Steve Swan", "Professional Bass", 50000.0);
		list.add(item16);

		return list;
	}

	public static void readFile(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
        } catch (IOException e) {
			System.out.println("Failed to read file.");
            e.printStackTrace();
        }
	}

	public static void writeToFile(String filePath, IAbstractItem itemObject) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Write some text to the file
			String data = String.format(
				"%s,%s,%s,%.2f,%s",
				itemObject.getClass().getSimpleName(),
				itemObject.getManufacturer(),
				itemObject.getItemName(),
				itemObject.getPrice(),
				itemObject.getUID()
			);
			writer.append(data);
			writer.newLine();
			writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
