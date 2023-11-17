package main.java.edu.depaul.customer;

import main.java.edu.depaul.shoppingcart.ShoppingCart;

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

    public void clearCart();

    /**
     * Retrieves the total of all items in the user's cart.
     * @return  The total cost of all items in the user's shopping cart
     **/
    public double getCartTotal();
}
