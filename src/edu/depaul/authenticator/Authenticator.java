package edu.depaul.authenticator;

import edu.depaul.customer.User;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

public class Authenticator {
    private Authenticator() {
        ;
    }

    public static boolean validateCustomerPassword(User user, String typedPassword) {
    	if (user == null) {
    		LogWriter.log(Level.WARNING, "User does not exist.", "NULL value entered.");
    		return false;
    	}
        String userPassword = user.getPassword();
        String test = Hash.hash(typedPassword);
        return userPassword.equals(test);
    }
}
