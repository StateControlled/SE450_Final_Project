package edu.depaul.order;

/**
 * Common methods an order or any potential similar classes will need.
 **/
public interface IOrderInterface {
    /**
     * Returns the order ID number.
     * @return  The order ID
     **/
    public long getOrderID();
    /**
     * Returns the order date as a string.
     * @return  The order date
     **/
    public String getOrderDate();
    /**
     * Returns the total cost of all items in this order.
     * @return The total cost
     **/
    public double getCost();
}
