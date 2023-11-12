package edu.depaul.item;

/**
 * The AbstractItem class serves as the basis for all the item classes.
 **/
public abstract class AbstractItem {
    protected String category;
    protected String itemType;
    protected String itemName;
    protected String manufacturer;
    protected double price;

    /**
     * Constructs a new item.
     **/
    public AbstractItem(String category, String itemType, String itemName, String manufacturer, double price) {
        this.category = category;
        this.itemType = itemType;
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Returns the item's price. Does not format the result.
     **/
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the item to the specified price.
     **/
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a simplified string representation of the object with no line breaks.
     * This method is intended for use to display in the program's GUI to allow a user to browse items for sale.
     **/
    public String view() {
        return String.format("%s, %s $%,.2f", itemName, manufacturer, price);
    }

    /**
     * <pre>
     * Returns a string representation of this item in the form:
     * 
     * Item: item ClassName
     * Description: itemName
     * Manufacturer: manufacturer
     * Price: $#,###.00
     * </pre>
     **/
    @Override
    public String toString() {
        return String.format("Item: %s\nDescription: %s\nManufacturer: %s\nPrice: %,.2f",this.getClass().getSimpleName(), itemName, manufacturer, price);
    }
}
