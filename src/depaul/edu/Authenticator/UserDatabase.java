package depaul.edu.Authenticator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import depaul.edu.Catalogue.AbstractCatalogue;
import depaul.edu.Customer.Customer;
import depaul.edu.Customer.IAbstractCustomer;

public class UserDatabase extends AbstractCatalogue<IAbstractCustomer> {
    private static final File CATALOGUE_FILE = new File("src\\depaul\\edu\\Authenticator\\users.csv");
    private static UserDatabase instance;
    //private static HashTable<String username, String hashedPassword> internalUserCatalogue;

    private UserDatabase() {
        super(CATALOGUE_FILE);
    }

    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    /**
     * Reads the class variable {@code CATALOGUE_FILE} and creates a java {@code ArrayList} of {@code Customer} objects from the data.
     **/
    protected static ArrayList<IAbstractCustomer> readFileToList(File file) {
        ArrayList<IAbstractCustomer> list = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = new ArrayList<>();
            String line;
            while ( (line = reader.readLine()) != null ) {
                String[] record = line.split(",");
                IAbstractCustomer customer = new Customer(record[0], record[1]);
                if (customer != null) {
                    list.add(customer);
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

    @Override
    public void writeToFile(File file, ArrayList<IAbstractCustomer> list, boolean append) {
        // TODO implement this
        throw new UnsupportedOperationException("Unimplemented method 'writeToFile'");
    }

    public ArrayList<IAbstractCustomer> readFromFile(File file) {
        ArrayList<IAbstractCustomer> list = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = new ArrayList<>();
            String line;
            while ( (line = reader.readLine()) != null ) {
                String[] record = line.split(",");
                IAbstractCustomer item = new Customer(record[0], record[1]);
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
