package edu.depaul.orderprocessor;

/**
 * Common methods an order or any potential similar classes will need.
 **/
public interface IOrderInterface {
    public long getOrderID();
    public String getOrderDate();
    public double getCost();
}
