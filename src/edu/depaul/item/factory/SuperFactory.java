package edu.depaul.item.factory;

import edu.depaul.item.AbstractItem;

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
        AbstractItem item = null;
        validate(category, itemType, itemName, manufacturer);
        
        if(category.equals("ELECTRONICS")) {
        	item = ElectronicsFactory.createProduct(category, itemType, itemName, manufacturer, price);
        } else if (category.equals("INSTRUMENT")) {
        	item = InstrumentFactory.createProduct(category, itemType, itemName, manufacturer, price);
        }
        return item;
    }

    private static void validate(String category, String itemType, String itemName, String manufacturer) throws IllegalArgumentException {
        if (category == null) {
        	throw new IllegalArgumentException("Item Category cannot be null");
        }
    	if (itemType == null) {
            throw new IllegalArgumentException("Item Type cannot be null");
        }
        if (itemName == null) {
            throw new IllegalArgumentException("Item Name cannot be null");
        }
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer cannot be null");
        }
    }

}
