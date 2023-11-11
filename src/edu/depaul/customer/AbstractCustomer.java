package edu.depaul.customer;

import edu.depaul.authenticator.Hash;

/**
 * An abstract class representing a customer. Stores the customer's username and (hashed) password.
 * The plaintext password should not be stored.
 **/
public abstract class AbstractCustomer {
    // TODO associate ShoppingCart
    private String name;
    private String password;

    /**
     * Constructor.
     **/
    public AbstractCustomer(String name, String password) {
        this.name = name;
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
}
