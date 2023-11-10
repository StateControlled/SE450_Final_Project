package depaul.edu.OrderProcessing;

import java.util.Date;
import java.util.ArrayList;

import depaul.edu.Customer.IAbstractCustomer;
import depaul.edu.Item.IAbstractItem;

public class Order implements IAbstractOrder {
    private long orderID;
    private double totalCost;
    private Date orderDate;
    private IAbstractCustomer customer;

    public Order(IAbstractCustomer customer, ArrayList<IAbstractItem> cart) {
        this.customer = customer;
        this.orderDate = new Date();
        setOrderID(orderDate);
        setCost(cart);
    }

    public void setCost(ArrayList<IAbstractItem> items) {
        double result = 0.0;
        for (IAbstractItem item : items) {
            result += item.getPrice();
        }
        totalCost = result;
    }

    public double getCost() {
        return totalCost;
    }

    public long getOrderID() {
        return orderID;
    }

    private void setOrderID(Date date) {
        long result = 2000000L + date.getTime() + customer.hashCode();
        this.orderID = result;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
