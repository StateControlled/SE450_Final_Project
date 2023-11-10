package depaul.edu.Catalogue;

import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import depaul.edu.Item.IAbstractItem;
import depaul.edu.Item.ItemFactory;

public class Catalogue extends AbstractCatalogue<IAbstractItem> {
    private static final File CATALOGUE_FILE = new File("src\\depaul\\edu\\Catalogue\\products.csv");
    private static Catalogue instance;

    private Catalogue(ArrayList<IAbstractItem> catalogueArray) {
        super(CATALOGUE_FILE);
    }

    public static Catalogue getInstance() {
        if (instance == null) {
            instance = new Catalogue(null);
        }
        return instance;
    }

    @Override
    public void writeToFile(File file, ArrayList<IAbstractItem> list, boolean append) {
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
            }
            writer.close();
        } catch (IOException e) {
		    System.out.println("Failed to read or write file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<IAbstractItem> readFromFile(File file) {
        ArrayList<IAbstractItem> list = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
    
}
