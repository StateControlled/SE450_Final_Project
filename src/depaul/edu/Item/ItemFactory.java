package depaul.edu.Item;

public class ItemFactory {

	private ItemFactory() {
		;
	}
	
	public static IAbstractItem createProduct(ItemType type, String manufacturer, String itemName, double price) {
		IAbstractItem item = null;
		if (type == ItemType.VIOLIN) {
			item = new Violin(manufacturer, itemName, price);
//		} else if (type == ItemType.VIOLA) {
//			item = new Viola(manufacturer, itemName, price);
//		} else if (type == ItemType.CELLO) {
//			item = new Cello(manufacturer, itemName, price);
//		} else if (type == ItemType.BASS) {
//			item = new Bass(manufacturer, itemName, price);
		} else if (type == ItemType.PIANO) {
			item = new Piano(manufacturer, itemName, price);
		}
		return item;
	}
}
