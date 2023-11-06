package depaul.edu.ShoppingCart;

import depaul.edu.Item.IAbstractItem;
import java.util.HashMap;

/**
 * {@code ShoppingCart} class represents a shopping cart that can store
 * a shopper's items until payment is processed.
 **/
public class ShoppingCart {
	/** Singleton instance of the shopping cart*/
	private static ShoppingCart SHOPPING_CART = null;
	/** Stores items and quantities. */
	private static HashMap<IAbstractItem, Integer> shoppingList;
	
	/**
	 * Private constructor
	 * @param builder
	 **/
	private ShoppingCart(ShoppingCartBuilder builder) {
		shoppingList = builder.shoppingList;
	}
	
	public static ShoppingCart getInstance() {
		if (SHOPPING_CART == null) {
			return new ShoppingCart.ShoppingCartBuilder().build();
		}
		return SHOPPING_CART;
	}

	public static int addToCart(IAbstractItem item) {
		if (shoppingList.keySet().contains(item)) {
			int temp = shoppingList.get(item);
			shoppingList.put(item, temp + 1);
			return shoppingList.get(item);
		}
		shoppingList.put(item, 1);
		return 1;
	}

	public static IAbstractItem removeFromCart(IAbstractItem item) {
		shoppingList.remove(item);
		return item;
	}

	public static HashMap<IAbstractItem, Integer> getShoppingList() {
		return shoppingList;
	}
	
	/**
	 * Internal builder class of {@code ShoppingCart} class.
	 */
	public static class ShoppingCartBuilder{
		private HashMap<IAbstractItem, Integer> shoppingList;
		
		/**
		 * Builder class constructor
		 **/
		public ShoppingCartBuilder(){
			this.shoppingList = new HashMap<>();
		}
		
		public ShoppingCart build(){
			return new ShoppingCart(this);
		}
	}
}