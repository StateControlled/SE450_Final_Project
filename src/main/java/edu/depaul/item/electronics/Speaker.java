package main.java.edu.depaul.item.electronics;

import main.java.edu.depaul.item.AbstractItem;

public class Speaker extends AbstractItem {

    public Speaker(String category, String itemType, String itemName, String manufacturer, double price) {
        super(category, itemType, itemName, manufacturer, price);
    }

    @Override
    public int hashCode() {
        return 31177 + this.itemType.hashCode() + this.manufacturer.hashCode() + this.itemName.hashCode() + ((Double) price).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Speaker)) {
            return false;
        }

        Speaker that = (Speaker) obj;
        return (this.itemName.equals(that.itemName)) && (this.manufacturer.equals(that.manufacturer)) && (Double.compare(this.price, that.price) == 0);
    }    
}
