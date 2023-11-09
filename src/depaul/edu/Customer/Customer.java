package depaul.edu.Customer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] byteArray = messageDigest.digest();

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < byteArray.length; i++) {
                builder.append(Integer.toHexString(0xFF & byteArray[i]));
            }
            this.password = builder.toString();
            return true;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("I don't think this will trigger.");
            e.printStackTrace();
        }
        return false;
    }

    public String getPassword() {
        return password;
    }
}
