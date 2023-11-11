package edu.depaul.factory;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.Category;

public class SuperFactory {
    private SuperFactory() {
        ;
    }

    public static AbstractItem getProduct(Category category, String itemType, String itemName, String manufacturer, double price) {
        AbstractItem item = null;
        if (category == Category.ELECTRONICS) {
            item = ElectronicsFactory.getProduct(category, itemType, itemName, manufacturer, price);
        } else if (category == Category.INSTRUMENT) {
            item = InstrumentFactory.getProduct(category, itemType, itemName, manufacturer, price);
        }
        return item;
    }
}
