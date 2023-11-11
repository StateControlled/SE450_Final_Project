package edu.depaul.orderprocessor;

import java.util.Date;

import edu.depaul.customer.AbstractCustomer;
import edu.depaul.item.AbstractItem;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

public class Order implements IOrderInterface {
    private long orderID;
    private double totalCost;
    private String orderDate;
    private AbstractCustomer customer;
    //private String cart;

    public Order(AbstractCustomer customer, ArrayList<AbstractItem> cart) {
        this.customer = customer;
        Date now = new Date();
        defineOrder(now, cart);
    }

    private void defineOrder(Date date, ArrayList<AbstractItem> cart) {
        this.orderID = setOrderID(date);
        this.totalCost = setCost(cart);
        this.orderDate = formatDate(date);
    }

    private long setOrderID(Date date) {
        return 2000000L + date.getTime() + customer.hashCode();
    }

    private double setCost(ArrayList<AbstractItem> cart) {
        double result = 0.0;
        for (AbstractItem item : cart) {
            result += item.getPrice();
        }
        return result;
    }

    private String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        return format.format(date);
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
