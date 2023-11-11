package edu.depaul.item;

public abstract class AbstractItem {
    protected Category superCategory;
    protected String category;
    protected String itemName;
    protected String manufacturer;
    protected double price;

    public AbstractItem(Category superCategory, String itemType, String itemName, String manufacturer, double price) {
        this.superCategory = superCategory;
        this.category = itemType;
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getCategory() {
        return category;
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
