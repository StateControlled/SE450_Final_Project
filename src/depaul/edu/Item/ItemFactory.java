package depaul.edu.Item;

public class ItemFactory {

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
}
