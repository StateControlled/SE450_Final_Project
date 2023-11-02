package depaul.edu.Tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import depaul.edu.Item.IAbstractItem;

//D:\Programming\SE450 Object Oriented Software Development\Final Project\SE450_Final_Project\src\depaul\edu\Catalogue

public class CatalogueTest {

    public static void main(String[] args) {
        // Define the file path for the CSV file
        String filePath = "src\\depaul\\edu\\Catalogue\\products.csv";
		//String testPath = "src\\depaul\\edu\\Catalogue\\testproducts.csv";

		readFile(filePath);
		
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
				"%s,%s,%s,%s",
				itemObject.getItemName(),
				itemObject.getManufacturer(),
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
