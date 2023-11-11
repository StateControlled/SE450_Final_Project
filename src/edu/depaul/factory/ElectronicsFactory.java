package edu.depaul.factory;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.Category;
import edu.depaul.item.electronics.CellPhone;
import edu.depaul.item.electronics.Computer;
import edu.depaul.item.electronics.Speaker;
import edu.depaul.item.electronics.Television;

public class ElectronicsFactory {
    private ElectronicsFactory() {
		;
    }

    public static AbstractItem getProduct(Category category, String itemType, String itemName, String manufacturer, double price) {
        AbstractItem item = null;
		if (itemType.equalsIgnoreCase("CELLPHONE")) {
			item = new CellPhone(category, "CELLPHONE", itemName, manufacturer, price);
		} else if (itemType.equalsIgnoreCase("TELEVISION")) {
			item = new Television(category, "TELEVISION", itemName, manufacturer, price);
		} else if (itemType.equalsIgnoreCase("COMPUTER")) {
			item = new Computer(category, "COMPUTER", itemName, manufacturer, price);
		} else if (itemType.equalsIgnoreCase("SPEAKER")) {
			item = new Speaker(category, "SPEAKER", itemName, manufacturer, price);
		}
		return item;
    }
}
