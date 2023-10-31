package depaul.edu;

/**
 * ShoppingCart class represents a shopping cart that can store
 * a shopper's items until payment is processed.
 **/
public class ShoppingCart {
	
	private static final ShoppingCart SHOPPING_CART = null;
	
	//required parameters
	private String field1;
	private String field2;
	
	/**
	 * Private constructor
	 * @param builder
	 **/
	private ShoppingCart(ShoppingCartBuilder builder) {
		this.field1 = builder.bField1;
		this.field2 = builder.bField2;
	}
	
	public static ShoppingCart getInstance() {
		if (SHOPPING_CART == null) {
			return new ShoppingCart.ShoppingCartBuilder().build();
		}
		return SHOPPING_CART;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}
	
	// Internal Builder Class
	public static class ShoppingCartBuilder{

		// required parameters
		private String bField1;
		private String bField2;
		
		public ShoppingCartBuilder(){
			this.bField1 = "0x1";
			this.bField2 = "0x2";
		}
		
		public ShoppingCart build(){
			return new ShoppingCart(this);
		}

	}

}