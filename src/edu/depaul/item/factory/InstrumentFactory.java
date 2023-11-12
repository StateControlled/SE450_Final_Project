package edu.depaul.item.factory;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.instrument.Bass;
import edu.depaul.item.instrument.Cello;
import edu.depaul.item.instrument.Piano;
import edu.depaul.item.instrument.Viola;
import edu.depaul.item.instrument.Violin;

public class InstrumentFactory {
    private InstrumentFactory() {
		;
    }

    protected static AbstractItem createProduct(String category, String itemType, String itemName, String manufacturer, double price) {
        AbstractItem item = null;
		if (itemType.equalsIgnoreCase("VIOLIN")) {
			item = new Violin(category, "VIOLIN", itemName, manufacturer, price);
		} else if (itemType.equalsIgnoreCase("VIOLA")) {
			item = new Viola(category, "VIOLA", itemName, manufacturer, price);
		} else if (itemType.equalsIgnoreCase("CELLO")) {
			item = new Cello(category, "CELLO", itemName, manufacturer, price);
		} else if (itemType.equalsIgnoreCase("BASS")) {
			item = new Bass(category, "BASS", itemName, manufacturer, price);
		} else if (itemType.equalsIgnoreCase("PIANO")) {
			item = new Piano(category, "PIANO", itemName, manufacturer, price);
		}
		return item;
    }
}
