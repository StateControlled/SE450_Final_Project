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
		this.UID = makeUID(manufacturer, itemName, Double.toString(price), this.getClass().getSimpleName());
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
	
	private String makeUID(String v1, String v2, String v3, String v4) {
		String concatenatedInputs = v1 + v2 + v3 + v4;
		return UUID.nameUUIDFromBytes(concatenatedInputs.getBytes()).toString();
	}

	@Override
	public int hashCode() {
		return 31159 + manufacturer.hashCode() + itemName.hashCode() + ((Double) price).hashCode() + UID.hashCode();
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
			if (!(obj instanceof Piano)) {
				return false;
			}

			Piano that = (Piano) obj;
			return (this.manufacturer.equals(that.manufacturer)) && (this.itemName.equals(that.itemName)) &&
				(Double.compare(this.price, that.price) == 0) && (this.UID.equals(that.UID));
		} catch (Exception e) {
			return false;
		}
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
