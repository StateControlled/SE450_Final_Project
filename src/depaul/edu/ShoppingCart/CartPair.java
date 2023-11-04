package depaul.edu.ShoppingCart;

public class CartPair<K, V> implements IPair<K, V> {
    private K key;
    private V value;

    public CartPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 31081 + key.hashCode() + value.hashCode();
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
            
            @SuppressWarnings("unchecked")
            CartPair<K, V> that = (CartPair<K, V>) obj;
            return ( this.key.equals(that.getKey() ) && ( this.value.equals(that.getValue()) ) );
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", key.toString(), value.toString());
    }


}
