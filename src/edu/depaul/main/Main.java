package edu.depaul.main;

import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import edu.depaul.catalogue.Catalogue;
import edu.depaul.catalogue.OrderDatabase;
import edu.depaul.catalogue.UserDatabase;
import edu.depaul.catalogue.UserPopulator;
import edu.depaul.customer.User;
import edu.depaul.gui.GUI;
import edu.depaul.item.AbstractItem;
import edu.depaul.item.ItemPopulator;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;
import edu.depaul.order.Order;
import edu.depaul.order.OrderPopulator;
import edu.depaul.resources.constants.StorageFiles;

public class Main {
    private User user;
	
	static {
		LogWriter.getLogWriter(StorageFiles.LOG_NAME);
	}
    
    public static void main(String[] args) {
    	String argument1 = null;
    	if (args.length > 0) {
    		argument1 = args[0];
    	}

        LogWriter.log(Level.INFO, "System start up", "Initialization.");
        
        // CATALOGUE
        File catalogue = StorageFiles.CATALOGUE_SOURCE;
        Catalogue cat = Catalogue.getInstance();
        LogWriter.log(Level.INFO, "CATALOGUE SOURCE: " + catalogue.toPath(), "Source file set.");
        
        if (argument1 != null && argument1.equals("-p")) {
            ArrayList<AbstractItem> items = ItemPopulator.generateItems();
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
        	ArrayList<User> users = UserPopulator.generateUsers();
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
        	ArrayList<Order> orders = OrderPopulator.generateOrders();
        	ord.writeToFile(orderDatabase, orders);
        }
        LogWriter.log(Level.INFO, "Read Order Database file.", "Source file populated.");
        
        int oSize = ord.getCatalogue().size();
        LogWriter.log(Level.INFO, "Populated " + oSize + " entities from file.", "");
        
        // START GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI.createAndShowGUI();
            }
        });
        
        
    }
}
