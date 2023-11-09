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
 * AbstractCatalogue is cool
 **/
public abstract class AbstractCatalogueTest {
    protected static File SOURCE_CATALOGUE_FILE;
    protected static ArrayList<IAbstractItem> CATALOGUE;

    /**
     * Constructs a new catalogue and 
     **/
    public AbstractCatalogueTest(File catalogueSource) {
        SOURCE_CATALOGUE_FILE = catalogueSource;
        CATALOGUE = readFileToList(SOURCE_CATALOGUE_FILE);
    }

    /**
     * Returns the file path of the source catalogue file.
     * @param absolute  if {@code true} will return the absolute path. If {@code false} will return a relative file path.
     **/
    public static String getCatalogueFilePath(boolean absolute) {
        if (absolute) {
            return SOURCE_CATALOGUE_FILE.getAbsolutePath();
        }
        return SOURCE_CATALOGUE_FILE.getPath();
    }

    /**
     * Returns the Catalogue in the form of an ArrayList.
     * @throws NullPointerException If the Catalogue is null.
     **/
    public static ArrayList<IAbstractItem> getCatalogueAsList() throws NullPointerException {
        if (CATALOGUE == null) {
            throw new NullPointerException("The Catalogue is NULL.");
        }
        return CATALOGUE;
    }

    /**
     * Writes a list of products to a given .csv file.
     * 
     * @param file  The file to write.
     * @param list  The list of data to be written to the file.
     * @param append    If {@code true}, append the list to the existing file.
     *                  If {@code false}, the existing file will not be preserved.
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
            }
            writer.close();
        } catch (IOException e) {
		    System.out.println("Failed to read or write file.");
            e.printStackTrace();
        }
    }    

    /**
     * Reads the class variable {@code CATALOGUE_FILE} and creates a java {@code ArrayList} of {@code IAbstractItem} objects from the data.
     **/
    protected static ArrayList<IAbstractItem> readFileToList(File file) {
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
