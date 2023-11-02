package depaul.edu.Tests;

import depaul.edu.Item.*;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ItemTests {
	private static String testPath = "src\\depaul\\edu\\Catalogue\\testproducts.csv";

	public static void main(String[] args) {
		System.out.println("Generating items...");
		ArrayList<IAbstractItem> list = createItems();

		System.out.println("All items added to list:");
		for (IAbstractItem i : list) {
			System.out.println(i.toString());
		}

		System.out.println("Write test...");
		for (IAbstractItem i : list) {
			writeToFile(testPath, i);
		}

		System.out.println("Read test");
		readFile(testPath);
	}

	public static ArrayList<IAbstractItem> createItems() {
		ArrayList<IAbstractItem> list = new ArrayList<>();

		//System.out.println("VIOLIN TEST*******************************************");
		// 93d4b63c-e8a0-3770-89eb-b18b3d20bace
		IAbstractItem item1 = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Trash Violin", 99.95);
		//System.out.println(item1.toString());
		list.add(item1);
	
		// 1dc01952-9f2c-3054-9237-1815fd1bd1b3
		IAbstractItem item2 = ItemFactory.createProduct(ItemType.VIOLIN, "Shar", "Student Violin", 900.0);
		//System.out.println(item2.toString());
		list.add(item2);
		
		IAbstractItem item3 = ItemFactory.createProduct(ItemType.VIOLIN, "Benjamin Ruth", "Professional Violin", 25500.0);
		//System.out.println(item3.toString());
		list.add(item3);

		//System.out.println("PIANO TEST*******************************************");
		IAbstractItem item4 = ItemFactory.createProduct(ItemType.PIANO, "Yamaha", "Digital Piano", 749.99);
		//System.out.println(item4.toString());
		list.add(item4);
		
		IAbstractItem item5 = ItemFactory.createProduct(ItemType.PIANO, "Baldwin", "Upright Piano", 13425.0);
		//System.out.println(item5.toString());
		list.add(item5);
		
		// 402a6713-40fb-3941-bc56-c1cf56faef46
		IAbstractItem item6 = ItemFactory.createProduct(ItemType.PIANO, "Steinway", "Grand Piano", 119400.0);
		//System.out.println(item6.toString());
		list.add(item6);

		//System.out.println("VIOLA TEST*******************************************");
		IAbstractItem item7 = ItemFactory.createProduct(ItemType.VIOLA, "Shar", "Beginner Viola", 279.99);
		//System.out.println(item7.toString());
		list.add(item7);

		IAbstractItem item8 = ItemFactory.createProduct(ItemType.VIOLA, "Yamaha", "Student Viola", 945.0);
		//System.out.println(item8.toString());
		list.add(item8);

		IAbstractItem item9 = ItemFactory.createProduct(ItemType.VIOLA, "Thomas Oliver Croen", "Professional Viola", 14000.0);
		//System.out.println(item9.toString());
		list.add(item9);

		
		//System.out.println("CELLO TEST*******************************************");
		IAbstractItem item10 = ItemFactory.createProduct(ItemType.CELLO, "Shar", "Beginner Cello", 899.0);
		//System.out.println(item10.toString());
		list.add(item10);

		IAbstractItem item11 = ItemFactory.createProduct(ItemType.CELLO, "Frederich Harbin", "Intermediate Cello", 3100.0);
		//System.out.println(item11.toString());
		list.add(item11);

		IAbstractItem item12 = ItemFactory.createProduct(ItemType.CELLO, "Thomas Hoyer", "Professional Cello", 20000.0);
		//System.out.println(item12.toString());
		list.add(item12);

		
		//System.out.println("BASS TEST*******************************************");
		IAbstractItem item13 = ItemFactory.createProduct(ItemType.BASS, "StradViolin.com", "Beginner Bass", 1925.0);
		//System.out.println(item13.toString());
		list.add(item13);

		IAbstractItem item14 = ItemFactory.createProduct(ItemType.BASS, "Shar", "Intermediate Bass", 2999.0);
		//System.out.println(item14.toString());
		list.add(item14);

		IAbstractItem item15 = ItemFactory.createProduct(ItemType.BASS, "Steve Swan", "Professional Bass", 50000.0);
		//System.out.println(item15.toString());
		list.add(item15);

		IAbstractItem item16 = ItemFactory.createProduct(ItemType.BASS, "Steve Swan", "Professional Bass", 50000.0);
		//System.out.println(item16.toString());
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
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
