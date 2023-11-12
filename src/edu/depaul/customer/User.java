package edu.depaul.customer;

import edu.depaul.shoppingcart.ShoppingCart;

public class User extends AbstractCustomer {
    private ShoppingCart cart;

    public User(int userID, String name, String password) {
        super(userID, name, password);
        cart = new ShoppingCart.ShoppingCartBuilder().build();
    }

    public ShoppingCart getCart() {
        return cart;
    }
    
}
