package edu.depaul.item.instrument;

import edu.depaul.item.AbstractItem;

public class Piano extends AbstractItem {

    public Piano(String category, String itemType, String itemName, String manufacturer, double price) {
        super(category, itemType, itemName, manufacturer, price);
    }

    @Override
    public int hashCode() {
        return 31159 + this.itemType.hashCode() + this.manufacturer.hashCode() + this.itemName.hashCode() + ((Double) price).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Piano)) {
            return false;
        }

        Piano that = (Piano) obj;
        return (this.itemName.equals(that.itemName)) && (this.manufacturer.equals(that.manufacturer)) && (Double.compare(this.price, that.price) == 0);
    }    
    
}
