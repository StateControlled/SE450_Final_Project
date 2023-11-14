package edu.depaul.shoppingcart;

import java.util.HashMap;

import edu.depaul.item.AbstractItem;

/**
 * This class represents a shopping cart. It stores items and quantities in a HashMap.
 * The class is implemented as a singleton class using a builder for setup.
 **/
public class ShoppingCart {
	/** Singleton instance of the shopping cart*/
	private static ShoppingCart shoppingCart;
	/** Stores items and quantities. */
	private static HashMap<AbstractItem, Integer> shoppingList;
	private static double total = 0.0;
	
	/**
	 * Private constructor.
	 **/
	private ShoppingCart(ShoppingCartBuilder builder) {
		shoppingList = builder.shoppingList;
		setTotal();
	}
	
	public static ShoppingCart getInstance() {
		if (shoppingCart == null) {
			return new ShoppingCart.ShoppingCartBuilder().build();
		}
		return shoppingCart;
	}

	/**
	 * Adds an item to the cart and updates the quantity.
	 **/
	public static int addToCart(AbstractItem item) {
		if (shoppingList.keySet().contains(item)) {
			int temp = shoppingList.get(item);
			shoppingList.put(item, temp + 1);
			return shoppingList.get(item);
		}
		shoppingList.put(item, 1);
		setTotal();
		return 1;
	}

	/**
	 * Completely removes an item from the cart. If quantity is greater than 1, this method will
	 * remove all items of that type.
	 **/
	public static AbstractItem removeFromCart(AbstractItem item) {
		shoppingList.remove(item);
		setTotal();
		return item;
	}
	
	public static void setTotal() {
		for (double p : shoppingList.values()) {
			total += p;
		}
	}

	public double getTotal() {
		return total;
	}

	public static HashMap<AbstractItem, Integer> getShoppingList() {
		return shoppingList;
	}
	
	/**
	 * Internal builder class of {@code ShoppingCart} class.
	 */
	public static class ShoppingCartBuilder{
		private HashMap<AbstractItem, Integer> shoppingList;
		
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
