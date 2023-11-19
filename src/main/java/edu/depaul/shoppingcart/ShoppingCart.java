package main.java.edu.depaul.shoppingcart;

import java.util.HashMap;

import main.java.edu.depaul.item.AbstractItem;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;

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
			shoppingCart = new ShoppingCart.ShoppingCartBuilder().build();
			LogWriter.log(Level.INFO, "Built new ShoppingCart", "INIT");
		}
		LogWriter.log(Level.INFO, "User Shopping Cart getInstance method call", "SHOPPING CART " + shoppingCart.toString());
		return shoppingCart;
	}

	/**
	 * Adds an item to the cart and updates the quantity.
	 **/
	public static int addToCart(AbstractItem item) {
		if (shoppingList.keySet().contains(item)) {
			shoppingList.put(item, shoppingList.get(item) + 1);
			LogWriter.log(Level.INFO, "Item " + item.getItemName() + " added to cart.", "Quantity " + shoppingList.get(item));
			setTotal();
			return shoppingList.get(item);
		}
		shoppingList.put(item, 1);
		LogWriter.log(Level.INFO, "Item " + item.getItemName() + " added to cart.", "Quantity 1");
		setTotal();
		return 1;
	}

	/**
	 * Completely removes an item from the cart.
	 **/
	public static AbstractItem removeFromCart(AbstractItem item) {
		if (shoppingList.get(item) > 1) {
			shoppingList.put(item, shoppingList.get(item) - 1);
		} else {
			shoppingList.remove(item);
		}
		setTotal();
		LogWriter.log(Level.INFO, "Item " + item.getItemName() + " removed from cart.", "Remaining " + shoppingList.get(item));
		return item;
	}
	
	public static void setTotal() {
		double newTotal = 0.0;
		if (shoppingList != null && shoppingList.size() > 0) {
			for (HashMap.Entry<AbstractItem, Integer> entry : shoppingList.entrySet()) {
				double price = entry.getKey().getPrice();
				int quantity = entry.getValue();
				newTotal += (price * quantity);
			}
		}
		total = newTotal;
		LogWriter.log(Level.INFO, String.format("Total updated %,.2f", newTotal), "PRICE UPDATED");
	}

	public static double getTotal() {
		return total;
	}

	public static HashMap<AbstractItem, Integer> getShoppingList() {
		return shoppingList;
	}

	public static void clearCart() {
		LogWriter.log(Level.WARNING, "Shopping Cart cleared", "CART CLEARED");
		shoppingList.clear();
		setTotal();
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
