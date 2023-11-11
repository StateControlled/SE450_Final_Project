package edu.depaul.factory;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.Category;
import edu.depaul.item.instrument.Bass;
import edu.depaul.item.instrument.Cello;
import edu.depaul.item.instrument.Piano;
import edu.depaul.item.instrument.Viola;
import edu.depaul.item.instrument.Violin;

public class InstrumentFactory {
    private InstrumentFactory() {
		;
    }

    public static AbstractItem getProduct(Category category, String itemType, String itemName, String manufacturer, double price) {
        AbstractItem item = null;
		if (itemType.equalsIgnoreCase("VIOLIN")) {
			item = new Violin(category, "VIOLIN", manufacturer, itemName, price);
		} else if (itemType.equalsIgnoreCase("VIOLA")) {
			item = new Viola(category, "VIOLA", manufacturer, itemName, price);
		} else if (itemType.equalsIgnoreCase("CELLO")) {
			item = new Cello(category, "VIOLONCELLO", manufacturer, itemName, price);
		} else if (itemType.equalsIgnoreCase("BASS")) {
			item = new Bass(category, "BASS", manufacturer, itemName, price);
		} else if (itemType.equalsIgnoreCase("PIANO")) {
			item = new Piano(category, "PIANO", manufacturer, itemName, price);
		}
		return item;
    }
}
