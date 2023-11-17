package edu.depaul.item.factory;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.instrument.Bass;
import edu.depaul.item.instrument.Cello;
import edu.depaul.item.instrument.Piano;
import edu.depaul.item.instrument.Viola;
import edu.depaul.item.instrument.Violin;

import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

public class InstrumentFactory {
    private InstrumentFactory() {
		;
    }

    protected static AbstractItem createProduct(String category, String itemType, String itemName, String manufacturer, double price) {
		itemType = itemType.toUpperCase();
		LogWriter.log(Level.INFO, String.format("Read item type %s", itemType), "");

		switch(itemType) {
			case "VIOLIN":
				return new Violin(category, "VIOLIN", itemName, manufacturer, price);
			case "VIOLA":
				return new Viola(category, "VIOLA", itemName, manufacturer, price);
			case "CELLO":
				return new Cello(category, "CELLO", itemName, manufacturer, price);
			case "BASS":
				return new Bass(category, "BASS", itemName, manufacturer, price);
			case "PIANO":
				return new Piano(category, "PIANO", itemName, manufacturer, price);
			default:
				LogWriter.log(Level.WARNING, "Failed to create item", "Item Type not valid");
				return null;
		}
    }
}
