package depaul.edu.Item;

import java.util.UUID;

public class Piano implements IAbstractItem {
	private String manufacturer;
	private String itemName;
	private double price;
	private final String UID;

	public Piano(String manufacturer, String itemName, double price) {
		this.manufacturer = manufacturer;
		this.itemName = itemName;
		this.price = price;
		this.UID = makeUID(manufacturer, itemName, Double.toString(price));
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public String getUID() {
		return UID;
	}
	
	private String makeUID(String v1, String v2, String v3) {
		String concatenatedInputs = v1 + v2 + v3;
		return UUID.nameUUIDFromBytes(concatenatedInputs.getBytes()).toString();
	}

	@Override
	public String toString() {
		return String.format("Item ID: %s\n" +
							 "Manufacturer: %s\n" +
							 "Description : %s\n" +
							 "Price: %.2f\n",
							 UID, manufacturer, itemName, price
							 );
	}
}
