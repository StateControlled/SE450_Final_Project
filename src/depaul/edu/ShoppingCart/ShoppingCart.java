package depaul.edu.ShoppingCart;

import depaul.edu.Item.IAbstractItem;
//import java.util.LinkedList;
import java.util.HashMap;

/**
 * {@code ShoppingCart} class represents a shopping cart that can store
 * a shopper's items until payment is processed.
 **/
public class ShoppingCart {
	/** Singleton */
	private static final ShoppingCart SHOPPING_CART = null;
	/** Stores items and quantities. */
	private static HashMap<IAbstractItem, Integer> shoppingList;
	//private static LinkedList<CartPair> shoppingList;
	
	//required parameters
	private String field1;
	
	/**
	 * Private constructor
	 * @param builder
	 **/
	private ShoppingCart(ShoppingCartBuilder builder) {
		this.field1 = builder.bField1;
		ShoppingCart.shoppingList = builder.shoppingList;
		//shoppingList = new LinkedList<>();
	}
	
	public static ShoppingCart getInstance() {
		if (SHOPPING_CART == null) {
			return new ShoppingCart.ShoppingCartBuilder().build();
		}
		return SHOPPING_CART;
	}

	public static CartPair addToCart(IAbstractItem item) {
		if (shoppingList.keySet().contains(item)) {
			int temp = shoppingList.get(item);
			shoppingList.put(item, temp + 1);
			return new CartPair(item, shoppingList.get(item));
		}
		shoppingList.put(item, 1);
		return new CartPair(item, shoppingList.get(item));
	}

	public static CartPair removeFromCart(IAbstractItem item) {
		shoppingList.remove(item);
		return new CartPair(item, shoppingList.get(item));
	}

	public static HashMap<IAbstractItem, Integer> getShoppingList() {
		return shoppingList;
	}

	public String getField1() {
		return field1;
	}
	
	/**
	 * Internal builder class of {@code ShoppingCart} class.
	 */
	public static class ShoppingCartBuilder{

		// required parameters
		private String bField1;
		private HashMap<IAbstractItem, Integer> shoppingList;
		
		/**
		 * Builder class constructor
		 **/
		public ShoppingCartBuilder(){
			this.bField1 = "0x1";
			this.shoppingList = new HashMap<>();
		}
		
		public ShoppingCart build(){
			return new ShoppingCart(this);
		}
	}

	/**
	 * Checks to see if an item already exists in the {@code shoppingList}.
	 * @return	{@code true} if the item exists in the list.
	 */
//	private static boolean checkForDuplicate(IAbstractItem item) {
//		for (CartPair pair : shoppingList) {
//			IAbstractItem temp = pair.getKey();
//			if (item.equals(temp)) {
//				return true;
//			}
//		}
//		return false;
//	}

}