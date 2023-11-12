package edu.depaul.orderprocessor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.depaul.customer.AbstractCustomer;
import edu.depaul.item.AbstractItem;

/**
 * The Order class serves as a record of a purchase made by a customer (User class).
 * It should be created after payment has been processed.
 **/
public class Order implements IOrderInterface {
    private long orderID;
    private double totalCost;
    private String orderDate;
    private AbstractCustomer customer;
    //private String cart;

    public Order(AbstractCustomer customer, ArrayList<AbstractItem> cart) {
        this.customer = customer;
        defineOrder(cart);
    }

    private void defineOrder(ArrayList<AbstractItem> cart) {
        Date now = new Date();
        setOrderID(now);
        setCost(cart);
        formatDate(now);
    }

    private void setOrderID(Date date) {
        this.orderID = 2000000L + date.getTime() + customer.hashCode();
    }

    private void setCost(ArrayList<AbstractItem> cart) {
        double result = 0.0;
        for (AbstractItem item : cart) {
            result += item.getPrice();
        }
        this.totalCost = result;
    }

    private void formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        this.orderDate = format.format(date);
    }

    @Override
    public long getOrderID() {
        return orderID;
    }

    @Override
    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public double getCost() {
        return totalCost;
    }
    
}
