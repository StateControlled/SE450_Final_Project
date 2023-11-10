package depaul.edu.Customer;

import depaul.edu.Authenticator.Hash;

public class Customer implements IAbstractCustomer {
    // TODO associate shopping cart
    private String username;
    private String password;

    public Customer(String username, String password) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean setPassword(String password) {
        if (password != null) {
            this.password = Hash.hash(password);
            return true;
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return username.hashCode() + password.hashCode() + 15373;
    }
}
