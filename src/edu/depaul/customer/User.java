package edu.depaul.customer;

import edu.depaul.authenticator.Hash;
import edu.depaul.shoppingcart.ShoppingCart;

/**
 * A class representing a customer. Stores the customer's username and (hashed) password and customer ID number.
 * The plaintext password should not be stored.
 **/
public class User {
    private int customerID;
    private String name;
    private String password;
    private ShoppingCart cart;

    /**
     * Constructor.
     **/
    public User(int customerID, String name, String password) {
        this.name = name;
        this.customerID = customerID;
        this.cart = new ShoppingCart.ShoppingCartBuilder().build();
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    /**
     * Hashes the password before associating it with the password field.
     **/
    public boolean setPassword(String password) {
        if (password != null) {
            this.password = Hash.hash(password);
            return true;
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void resetPassword(String password) {
        this.password = password;
    }

    public int getCustomerID() {
        return customerID;
    }
    
    public ShoppingCart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return String.format("%d : %s", this.customerID, this.name);
    }
}
