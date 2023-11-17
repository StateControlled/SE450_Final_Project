package edu.depaul.customer;

import edu.depaul.shoppingcart.ShoppingCart;

public interface IUserInterface {
    /**
     * 
     **/
    public String getName();
    public void setName(String name);

    /**
     * Sets the password. Hashes the password first.
     * @param password  the plaintext password
     * @return {@code true} if password is successfully hashed and set
     **/
    public boolean setPassword(String password);

    public String getPassword();

    public int getCustomerID();
    
    public ShoppingCart getCart();
}
