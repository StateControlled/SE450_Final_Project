package depaul.edu.Catalogue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import depaul.edu.Item.IAbstractItem;

public class Catalogue {
    private static final File CATALOGUE_FILE = new File("src\\depaul\\edu\\Catalogue\\products.csv");

    public static void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ( (line = reader.readLine() ) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
        } catch (IOException e) {
		    System.out.println("Failed to read file.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(File file, ArrayList<IAbstractItem> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (IAbstractItem item : list) {
                String data = String.format(
                    "%s,%s,%s,%.2f,%s",
                        item.getClass().getSimpleName(),
                        item.getManufacturer(),
                        item.getItemName(),
                        item.getPrice(),
                        item.getUID()
			    );
			writer.append(data);
			writer.newLine();
			writer.close();
            }
        } catch (IOException e) {
		    System.out.println("Failed to read or write file.");
            e.printStackTrace();
        }
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
