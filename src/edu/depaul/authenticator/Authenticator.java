package edu.depaul.authenticator;

import edu.depaul.customer.User;

public class Authenticator {
    private Authenticator() {
        ;
    }

    public static boolean validateCustomerPassword(User user, String typedPassword) {
        String userPassword = user.getPassword();
        String test = Hash.hash(typedPassword);
        return userPassword.equals(test);
    }
}
