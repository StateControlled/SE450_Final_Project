package edu.depaul.item.instrument;

import edu.depaul.item.AbstractItem;

public class Viola extends AbstractItem {

    public Viola(String category, String itemType, String itemName, String manufacturer, double price) {
        super(category, itemType, itemName, manufacturer, price);
    }

    @Override
    public int hashCode() {
        return 31159 + this.itemType.hashCode() + this.manufacturer.hashCode() + this.itemName.hashCode() + ((Double) price).hashCode();
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
            if (!(obj instanceof Viola)) {
                return false;
            }

            Viola that = (Viola) obj;
            return (this.itemName.equals(that.itemName)) && (this.manufacturer.equals(that.manufacturer)) && (Double.compare(this.price, that.price) == 0);
        } catch (Exception e) {
            return false;
        }
    }    
    
}
