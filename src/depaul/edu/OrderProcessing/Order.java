package depaul.edu.OrderProcessing;

import java.util.Date;
import java.util.ArrayList;

import depaul.edu.Customer.IAbstractCustomer;
import depaul.edu.Item.IAbstractItem;
import java.text.SimpleDateFormat;

public class Order implements IAbstractOrder {
    private long orderID;
    private double totalCost;
    private String orderDate;
    private IAbstractCustomer customer;

    public Order(IAbstractCustomer customer, ArrayList<IAbstractItem> cart) {
        this.customer = customer;
        initialize(cart);
    }

    private void initialize(ArrayList<IAbstractItem> cart) {
        Date now = new Date();
        this.orderID = setOrderID(now);
        this.totalCost = setCost(cart);
        this.orderDate = formatDate(now);
    }

    public double setCost(ArrayList<IAbstractItem> items) {
        double result = 0.0;
        for (IAbstractItem item : items) {
            result += item.getPrice();
        }
        return result;
    }

    public double getCost() {
        return totalCost;
    }

    private long setOrderID(Date date) {
        return 2000000L + date.getTime() + customer.hashCode();
    }

    public long getOrderID() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String toCsvFormat() {
        return String.format("%d,%s,%s,%,.2f", orderID, orderDate.toString(), customer.getUsername(), totalCost);
    }

    private String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        return format.format(date);
    }
}
