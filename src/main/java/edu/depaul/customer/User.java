package main.java.edu.depaul.customer;

import main.java.edu.depaul.authenticator.Hash;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;
import main.java.edu.depaul.shoppingcart.ShoppingCart;

/**
 * A class representing a customer. Stores the customer's username and (hashed) password and customer ID number.
 * The plaintext password should not be stored.
 **/
public class User implements IUserInterface {
    private int customerID;
    private String name;
    private String password;
    private ShoppingCart cart;

    /**
     * Constructor.
     **/
    public User(int customerID, String name, String password) {
        LogWriter.log(Level.INFO, "User constructor called.", "CLASS CONSTRUCTOR");
        this.name = name;
        this.customerID = customerID;
        this.cart = ShoppingCart.getInstance();
        setPassword(password);
    }

    public String getName() {
        return name;
    }

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
