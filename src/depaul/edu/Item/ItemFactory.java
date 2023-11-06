package depaul.edu.Item;

/**
 * The {@code ItemFactory} class decides what type of item to construct based on an {@code Enum} {@code ItemType} or
 * matching {@code String}. If a given {@code type} does not match any currently implemented items, a {@code null} value will 
 * be returned.
 **/
public class ItemFactory {

	/**
	 * Private constructor to force the user to interact with the {@code createProduct} method.
	 **/
	private ItemFactory() {
		;
	}
	
	public static IAbstractItem createProduct(ItemType type, String manufacturer, String itemName, double price) {
		IAbstractItem item = null;
		switch (type) {
			case VIOLIN:
				item = new Violin(manufacturer, itemName, price);
				break;
			case VIOLA:
				item = new Viola(manufacturer, itemName, price);
				break;
			case CELLO:
				item = new Cello(manufacturer, itemName, price);
				break;
			case BASS:
				item = new Bass(manufacturer, itemName, price);
				break;
			case PIANO:
				item = new Piano(manufacturer, itemName, price);
				break;
			default:
				break;
		}
		return item;
	}

	public static IAbstractItem createProduct(String type, String manufacturer, String itemName, double price) {
		IAbstractItem item = null;
		if (type.equalsIgnoreCase("VIOLIN")) {
			item = new Violin(manufacturer, itemName, price);
		} else if (type.equalsIgnoreCase("VIOLA")) {
			item = new Viola(manufacturer, itemName, price);
		} else if (type.equalsIgnoreCase("CELLO")) {
			item = new Cello(manufacturer, itemName, price);
		} else if (type.equalsIgnoreCase("BASS")) {
			item = new Bass(manufacturer, itemName, price);
		} else if (type.equalsIgnoreCase("PIANO")) {
			item = new Bass(manufacturer, itemName, price);
		}
		return item;
	}
}
