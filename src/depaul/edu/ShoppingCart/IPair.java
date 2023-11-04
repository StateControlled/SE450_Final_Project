package depaul.edu.ShoppingCart;

public interface IPair<K, V> {
    public K getKey();
    public void setKey(K left);
    public V getValue();
    public void setValue(V right);
}
