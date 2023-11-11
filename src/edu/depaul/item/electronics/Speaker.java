package edu.depaul.item.electronics;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.Category;

public class Speaker extends AbstractItem {

    public Speaker(Category category, String itemType, String itemName, String manufacturer, double price) {
        super(category, itemType, itemName, manufacturer, price);
    }

    @Override
    public int hashCode() {
        return 31177 + this.category.hashCode() + this.manufacturer.hashCode() + this.itemName.hashCode() + ((Double) price).hashCode();
    }
    
}
