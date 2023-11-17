package main.java.edu.depaul.item.factory;

import main.java.edu.depaul.item.AbstractItem;
import main.java.edu.depaul.item.instrument.Bass;
import main.java.edu.depaul.item.instrument.Cello;
import main.java.edu.depaul.item.instrument.Piano;
import main.java.edu.depaul.item.instrument.Viola;
import main.java.edu.depaul.item.instrument.Violin;

import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;

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
