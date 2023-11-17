package main.java.edu.depaul.item.factory;

import main.java.edu.depaul.item.AbstractItem;
import main.java.edu.depaul.item.electronics.CellPhone;
import main.java.edu.depaul.item.electronics.Computer;
import main.java.edu.depaul.item.electronics.Speaker;
import main.java.edu.depaul.item.electronics.Television;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;

public class ElectronicsFactory {
	private ElectronicsFactory() {
		;
	}

	protected static AbstractItem createProduct(String category, String itemType, String itemName, String manufacturer, double price) {
		itemType = itemType.toUpperCase();
		LogWriter.log(Level.INFO, String.format("Read item type %s", itemType), "");

		switch (itemType) {
			case "CELLPHONE":
				return new CellPhone(category, "CELLPHONE", itemName, manufacturer, price);
			case "TELEVISION":
				return new Television(category, "TELEVISION", itemName, manufacturer, price);
			case "COMPUTER":
				return new Computer(category, "COMPUTER", itemName, manufacturer, price);
			case "SPEAKER":
				return new Speaker(category, "SPEAKER", itemName, manufacturer, price);
			default:
				LogWriter.log(Level.WARNING, "Failed to create item", "Item Type not valid");
				return null;
		}
		

		
    }
}
