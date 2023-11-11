package edu.depaul.item.electronics;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.Category;

public class Computer extends AbstractItem {

    public Computer(Category category, String itemType, String itemName, String manufacturer, double price) {
        super(category, itemType, itemName, manufacturer, price);
    }

    @Override
    public int hashCode() {
        return 31177 + this.category.hashCode() + this.manufacturer.hashCode() + this.itemName.hashCode() + ((Double) price).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Computer)) {
                return false;
            }

            Computer that = (Computer) obj;
            return (this.itemName.equals(that.itemName)) && (this.manufacturer.equals(that.manufacturer)) && (Double.compare(this.price, that.price) == 0);
        } catch (Exception e) {
            return false;
        }
    }        
    
}
