package depaul.edu.ShoppingCart;

import depaul.edu.Item.IAbstractItem;

/**
 * The CartPair class associates an item with a quantity and provides methods to retrieve
 * either value, increment and decrement quantity, and compare pairs.
 **/
public class CartPair implements IPair<IAbstractItem, Integer> {
    private IAbstractItem key;
    private Integer quantity;

    public CartPair(IAbstractItem key, Integer quantity) {
        this.key = key;
        this.quantity = quantity;
    }

    public int increaseQuantity() {
        quantity += 1;
        return quantity;
    }

    public int decreaseQuantity() {
        if (quantity > 0) {
            quantity -= 1;
        }
        return quantity;
    }

    @Override
    public IAbstractItem getKey() {
        return this.key;
    }

    @Override
    public void setKey(IAbstractItem key) {
        this.key = key;
    }

    @Override
    public Integer getValue() {
        return this.quantity;
    }

    @Override
    public void setValue(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return 31081 + key.hashCode() + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if ( !(obj instanceof CartPair) ) {
                return false;
            }
            
            CartPair that = (CartPair) obj;
            return ( this.key.equals(that.key ) && ( this.quantity == that.quantity) );
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %d)", key.getItemName(), quantity);
    }


}
