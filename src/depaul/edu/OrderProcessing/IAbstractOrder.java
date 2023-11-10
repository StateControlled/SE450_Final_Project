package depaul.edu.OrderProcessing;

import java.util.Date;

public interface IAbstractOrder {
    public long getOrderID();
    public Date getOrderDate();
    public double getCost();
}
