package edu.depaul.customer;

import edu.depaul.shoppingcart.ShoppingCart;

public class User extends AbstractCustomer {
    private ShoppingCart cart;

    public User(String name, String password) {
        super(name, password);
        cart = new ShoppingCart.ShoppingCartBuilder().build();
    }

    public ShoppingCart getCart() {
        return cart;
    }
    
}
