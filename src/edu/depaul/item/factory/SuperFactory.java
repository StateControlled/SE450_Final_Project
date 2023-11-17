package edu.depaul.item.factory;

import edu.depaul.item.AbstractItem;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

/**
 * The SuperFactory is designed to dynamically create an appropriate product based on given parameters.
 * It will call other factory classes to construct the actual product.
 **/
public class SuperFactory {
    private SuperFactory() {
        ;
    }

    /**
     * Factory for creating an item.
     * 
     * @param category  the general category to which the item belongs.
     * @param itemType  the item's type or "what" the item is. For example: Violin, Cellphone, Piano.
     * @param itemName  the item's name or short description.
     * @param manufacturer  the item's manufacturer.
     * @param price the price of the item. May be zero or a negative number (not recommended).
     * @return  An item of the matching {@code Category}.
     * @throws IllegalArgumentException If any parameter is {@code null}.
     **/
    public static AbstractItem createProduct(String category, String itemType, String itemName, String manufacturer, double price) throws IllegalArgumentException {
        validate(category, itemType, itemName, manufacturer);
        LogWriter.log(Level.INFO, "SuperFactory called", "Pass arguments to sub-factories");

        switch (category) {
            case "ELECTRONICS":
                return ElectronicsFactory.createProduct(category, itemType, itemName, manufacturer, price);
            case "INSTRUMENT":
                return InstrumentFactory.createProduct(category, itemType, itemName, manufacturer, price);
            default:
                LogWriter.log(Level.SEVERE, "Category not found", "VALIDATION FAILED");
                return null;
        }
    }

    /**
     * This method checks to see if any arguements are null. Accepts arguments from the above {@code createProduct} method.
     * @throws IllegalArgumentException If any of the arguments are null
     **/
    private static void validate(String category, String itemType, String itemName, String manufacturer) throws IllegalArgumentException {
        if (category == null) {
            LogWriter.log(Level.SEVERE, "Parameter category cannot be null", new IllegalArgumentException("Item Category cannot be null"));
        	throw new IllegalArgumentException("Item Category cannot be null");
        }
    	if (itemType == null) {
            LogWriter.log(Level.SEVERE, "Parameter itemType cannot be null", new IllegalArgumentException("Item Type cannot be null"));
            throw new IllegalArgumentException("Item Type cannot be null");
        }
        if (itemName == null) {
            LogWriter.log(Level.SEVERE, "Parameter itemName cannot be null", new IllegalArgumentException("Item Name cannot be null"));
            throw new IllegalArgumentException("Item Name cannot be null");
        }
        if (manufacturer == null) {
            LogWriter.log(Level.SEVERE, "Parameter manufacturer cannot be null", new IllegalArgumentException("Manufacturer cannot be null"));
            throw new IllegalArgumentException("Manufacturer cannot be null");
        }
    }

}
