package main.java.edu.depaul.order;

import main.java.edu.depaul.catalogue.OrderDatabase;
import main.java.edu.depaul.customer.User;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;
import main.java.edu.depaul.shoppingcart.ShoppingCart;

public class OrderProcessor {
    private OrderProcessor() {
        ;
    }

    /**
     * Creates a new order, adds it to the OrderDatabase, and clears the User's cart so a new order can be made.
     * @return  The new order
     **/
    public static Order processOrder(User user) {
        LogWriter.log(Level.INFO, "CREATE ORDER", "Order confirmed");
        user.getCart();
        OrderDatabase orderDatabase = OrderDatabase.getInstance();
        Order order = new Order(user, ShoppingCart.getShoppingList());

        LogWriter.log(Level.INFO, "Added order " + order.getOrderID() + " to Order Database", "Database update");
        orderDatabase.addEntry(order);
        user.addOrder(order.getOrderID());
        user.clearCart();  
        return order;      
    }
}
