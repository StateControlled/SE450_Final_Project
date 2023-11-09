package depaul.edu.Authenticator;

import depaul.edu.Customer.Customer;

public class Authenticator {
    private Authenticator() {
        ;
    }

    public static boolean validateCustomerPassword(Customer user, String typedPassword) {
        String userPassword = user.getPassword();
        String test = Hash.hash(typedPassword);
        return userPassword.equals(test);
    }
}
