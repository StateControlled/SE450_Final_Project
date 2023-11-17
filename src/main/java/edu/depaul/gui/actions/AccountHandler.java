package edu.depaul.gui.actions;

import java.util.ArrayList;

import edu.depaul.authenticator.Authenticator;
import edu.depaul.catalogue.UserDatabase;
import edu.depaul.customer.User;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

public class AccountHandler {
    private AccountHandler() {
        ;
    }

    public static User checkUser(String username, String password, String command) {
        LogWriter.log(Level.INFO, "Searching for user \"" + username + "\"", command);
        UserDatabase d = UserDatabase.getInstance();
        User user = d.findInCatalogue(username);
        if (user == null) {
            if (command.equals("Create Account")) {
                int id = 0;
                ArrayList<User> array = d.getCatalogue();

                for (User u : array) {
                    id = u.getCustomerID() > id ? u.getCustomerID() : id;
                }
                id += 1;
                return createNewUser(id, username, password);
            } else if (command.equals("Log in")) {
                LogWriter.log(Level.WARNING, "User " + username + " does not exist.", "LOG IN ERROR");
            } else {
                LogWriter.log(Level.SEVERE, "User " + username + " does not exist.", "COMMAND PARSE FAILURE");
            }
        } else {
            return loginUser(user, password);
        }
        return null;
    }

    public static User createNewUser(int newUserID, String username, String password) {
        User user = new User(newUserID, username, password);
        UserDatabase d = UserDatabase.getInstance();
        d.addEntry(user);
        LogWriter.log(Level.INFO, "Created new user " + username, "NEW ACCOUNT CREATED");
        return user;
    }

    public static User loginUser(User user, String password) {
        if (user == null) {
            LogWriter.log(Level.WARNING, "User not found", "User is null");
            return null;
        } else {
            if (Authenticator.validateCustomerPassword(user, password)) {
                LogWriter.log(Level.INFO, "User log in Successful", user.getName());
                return user;
            } else {
                LogWriter.log(Level.WARNING, "User log in Failed", user.getName());
            }
        }
        return null;
    }
}
