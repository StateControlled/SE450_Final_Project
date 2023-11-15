package edu.depaul.gui.actions;

import edu.depaul.customer.User;
//import edu.depaul.customer.User;
import edu.depaul.item.AbstractItem;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;
import edu.depaul.shoppingcart.ShoppingCart;

public class CartOperations {
    private CartOperations() {
        ;
    }    

    public static void addToCart(User user, AbstractItem item) {
        try {
            user.getCart();
            ShoppingCart.getInstance();
            ShoppingCart.addToCart(item);
            LogWriter.log(Level.INFO, "Added item to cart", item.getItemName());
        } catch (Exception e) {
            LogWriter.log(Level.SEVERE, "Failed to add item to cart", e);
            if (user == null) {
                LogWriter.log(Level.SEVERE, "User is null", "Null value not allowed");
            } else if (item == null) {
                LogWriter.log(Level.SEVERE, "Item is null", "Null value not allowed");
            } else {
                ;
            }
        }
        return;
    }

    public static void removeFromCart(User user, AbstractItem item) {
        // TODO implement
        LogWriter.log(Level.SEVERE,"UNIMPLEMENTED METHOD" , "REMOVE METHOD NOT IMPLEMENTED");
    }
}
