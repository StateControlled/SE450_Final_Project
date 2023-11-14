package edu.depaul.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import edu.depaul.customer.User;
import edu.depaul.item.AbstractItem;

/**
 * The Order class serves as a record of a purchase made by a customer (User class).
 * It should be created after payment has been processed.
 **/
public class Order implements IOrderInterface {
    private long orderID;
    private double totalCost;
    private String orderDate;
    private int customerID;
    private String customerName;
    private HashMap<String, Integer> cart;

    
    public Order(User customer, HashMap<AbstractItem, Integer> cart) {
    	this.customerID = customer.getCustomerID();
    	this.customerName = customer.getName();
    	defineOrder(cart);
    }
    
    private void defineOrder(HashMap<AbstractItem, Integer> cart) {
        Date now = new Date();
        setOrderID(now);
        setCost(cart);
        formatDate(now);
        setCart(cart);
    }

    private void setOrderID(Date date) {
        this.orderID = customerID + 2002199L + date.getTime() + date.hashCode();
    }
    
    private void setCost(HashMap<AbstractItem, Integer> cart) {
        double result = 0.0;
        for (AbstractItem item : cart.keySet()) {
        	double price = item.getPrice();
        	int quantity = cart.get(item);
        	result += (price * quantity);
        }
        this.totalCost = result;
    }

    private void formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        this.orderDate = format.format(date);
    }
    
    private void setCart(HashMap<AbstractItem, Integer> cart) {
    	this.cart = new HashMap<>();
    	for (AbstractItem item : cart.keySet()) {
    		this.cart.put(item.getItemName(), cart.get(item));
    	}
    }
    
    public String getCustomerName() {
    	return customerName;
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
