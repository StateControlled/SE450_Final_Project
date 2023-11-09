package depaul.edu.Authenticator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import depaul.edu.Catalogue.AbstractCatalogue;
import depaul.edu.Customer.Customer;

public class UserDatabase extends AbstractCatalogue<Customer> {
    private static final File CATALOGUE_FILE = new File("src\\depaul\\edu\\Authenticator\\users.csv");
    private static UserDatabase INSTANCE;

    private UserDatabase() {
        super(CATALOGUE_FILE, readFileToList(CATALOGUE_FILE));
    }

    public static UserDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserDatabase();
        }
        return INSTANCE;
    }

    public void refreshCatalogue() {
        setCatalogueArray(readFileToList(CATALOGUE_FILE));
    }

    /**
     * Reads the class variable {@code CATALOGUE_FILE} and creates a java {@code ArrayList} of {@code Customer} objects from the data.
     **/
    protected static ArrayList<Customer> readFileToList(File file) {
        ArrayList<Customer> list = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = new ArrayList<>();
            String line;
            while ( (line = reader.readLine()) != null ) {
                //String[] record = line.split(",");
                Customer item = null;
                //if (item != null) {
                    list.add(item);
                ///}
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

    @Override
    public void writeToFile(File file, ArrayList<Customer> list, boolean append) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeToFile'");
    }

    @Override
    public ArrayList<Customer> readFromFile(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFromFile'");
    }
    
}
