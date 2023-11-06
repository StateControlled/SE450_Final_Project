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
import depaul.edu.Item.ItemFactory;

/**
 * The {@code CATALOGUE} is a list of products that are available for a user to view. <p>
 * 
 * The Catalogue class contains methods for accessing and modifying the {@code CATALOGUE}. <p>
 * 
 * Call {@code Catalogue.getInstance()} first.
 **/
public class Catalogue {
    private static File CATALOGUE_FILE = new File("src\\depaul\\edu\\Catalogue\\products.csv");
    private static ArrayList<IAbstractItem> CATALOGUE;
    private static Catalogue INSTANCE;

    private Catalogue() {
        CATALOGUE = readFileToList();
    }

    public static Catalogue getInstance() {
        if (CATALOGUE == null) {
            INSTANCE = new Catalogue();
        }
        return INSTANCE;
    }

    /**
     * Returns the Catalogue in the form of an ArrayList.
     **/
    public static ArrayList<IAbstractItem> getCatalogueAsList() {
        return CATALOGUE;
    }

    /**
     * Searches for a match to a given key in the manufacturer's names of all items in the {@code CATALOGUE}.
     **/
    public static ArrayList<IAbstractItem> findManufacturer(String key) {
        ArrayList<IAbstractItem> results = new ArrayList<>();
        String lKey = key.toLowerCase();
        for (IAbstractItem i : CATALOGUE) {
            String name = i.getManufacturer().toLowerCase();
            if (name.contains(lKey)) {
                results.add(i);
            }
        }
        return results;
    }

    /**
     * Searches for a match to a given key in the item names of all items in the {@code CATALOGUE}.
     **/
    public static ArrayList<IAbstractItem> findName(String key) {
        ArrayList<IAbstractItem> results = new ArrayList<>();
        String lKey = key.toLowerCase();
        for (IAbstractItem i : CATALOGUE) {
            String name = i.getItemName().toLowerCase();
            if (name.contains(lKey)) {
                results.add(i);
            }
        }
        return results;
    }

    /**
     * Reads the class variable {@code CATALOGUE_FILE} and creates a java {@code ArrayList} of {@code IAbstractItem} objects from the data.
     **/
    private static ArrayList<IAbstractItem> readFileToList() {
        ArrayList<IAbstractItem> list = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(CATALOGUE_FILE))) {
            list = new ArrayList<>();
            String line;
            while ( (line = reader.readLine()) != null ) {
                String[] record = line.split(",");
                IAbstractItem item = ItemFactory.createProduct(record[0], record[1], record[2], Double.parseDouble(record[3]));
                if (item != null) {
                    list.add(item);
                }
            }
        } catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
        } catch (IOException e) {
		    System.out.println("Failed to read file.");
            e.printStackTrace();
        }        
        return list;
    }

    /**
     * Reads data from a file and prints it to the console.
     * @param file
     **/
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

    /**
     * Writes a list of products to a given .csv file. <p>
     * The list will be appended to any existing data in the file.
     * @param file  The file to write.
     * @param list  The list of data to be written to the file.
     **/
    public static void writeToFile(File file, ArrayList<IAbstractItem> list, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
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
}
