package main.java.edu.depaul.gui;

import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import main.java.edu.depaul.catalogue.Catalogue;
import main.java.edu.depaul.catalogue.OrderDatabase;
import main.java.edu.depaul.catalogue.UserDatabase;
import main.java.edu.depaul.customer.User;
import main.java.edu.depaul.customer.UserPopulator;
import main.java.edu.depaul.item.AbstractItem;
import main.java.edu.depaul.item.ItemPopulator;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;
import main.java.edu.depaul.order.Order;
import main.java.edu.depaul.order.OrderPopulator;
import main.java.edu.depaul.paymentprocessor.PaymentProcessor;
import main.resources.constants.StorageFiles;

/**
 * Constructs the UserDatabase, Catalogue, and OrderDatabase then creates the GUI.
 **/
public class Main {
    // Initialize the LogWriter	before anything else.
	static {
		LogWriter.getLogWriter(StorageFiles.LOG_NAME);
        PaymentProcessor.getProcessor();
	}
    
    public static void main(String[] args) {
    	String argument1 = null;
    	if (args.length > 0) {
    		argument1 = args[0];
    	}

        LogWriter.log(Level.INFO, "System start up", "Initialization.");

        initDatabases(argument1);
        
        // START GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Application();
            }
        });
    }

    /**
     * Does the work of initializing the databases
     **/
    private static void initDatabases(String argument1) {
        // CATALOGUE
        File catalogue = StorageFiles.CATALOGUE_SOURCE;
        Catalogue cat = Catalogue.getInstance();
        LogWriter.log(Level.INFO, "CATALOGUE SOURCE: " + catalogue.getAbsolutePath(), "Source file set.");
        
        if (argument1 != null && argument1.equals("-p")) {
            ArrayList<AbstractItem> items = new ItemPopulator().generate();
            cat.writeToFile(catalogue, items);        	
        }

        LogWriter.log(Level.INFO, "Read Catalogue file.", "Source file populated.");
        
        int cSize = cat.size();
        LogWriter.log(Level.INFO, "Populated " + cSize + " entities from file.", "");
        
        // DATABASE
        File userDatabase = StorageFiles.USER_DATABASE;
        UserDatabase dat = UserDatabase.getInstance();
        LogWriter.log(Level.INFO, "USER DATABASE SOURCE: " + userDatabase.toPath(), "Source file set.");
        
        if (argument1 != null && argument1.equals("-p")) {
        	ArrayList<User> users = new UserPopulator().generate();
        	dat.writeToFile(userDatabase, users);
        }
        LogWriter.log(Level.INFO, "Read User Database file.", "Source file populated.");
        
        int dSize = dat.getCatalogue().size();
        LogWriter.log(Level.INFO, "Populated " + dSize + " entities from file.", "");
        
        // ORDERS
        File orderDatabase = StorageFiles.ORDER_DATABASE;
        OrderDatabase ord = OrderDatabase.getInstance();
        LogWriter.log(Level.INFO, "ORDER DATABASE SOURCE: " + orderDatabase.toPath(), "Source file set.");
        
        if (argument1 != null && argument1.equals("-p")) {
        	ArrayList<Order> orders = new OrderPopulator().generate();
        	ord.writeToFile(orderDatabase, orders);
        }
        LogWriter.log(Level.INFO, "Read Order Database file.", "Source file populated.");
        
        int oSize = ord.getCatalogue().size();
        LogWriter.log(Level.INFO, "Populated " + oSize + " entities from file.", "");
    }
}
