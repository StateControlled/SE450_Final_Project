package edu.depaul.handlers;

import java.awt.event.ActionEvent;

import edu.depaul.customer.User;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

public class ButtonHandler {

    public static User actionPerformed(ActionEvent e, User currentUser, String username, String password) {
        LogWriter.log(Level.INFO, "Control Panel Button Press", e.getActionCommand());
        LogWriter.log(Level.INFO, String.format("READ: %s, %s", username, password), e.getActionCommand());
        if (e.getActionCommand().equals("Log in")) {
            LogWriter.log(Level.INFO, "Log in existing user", "");
            currentUser = AccountHandler.checkUser(username, password, e.getActionCommand());
            if (currentUser != null) {
                LogWriter.log(Level.INFO, currentUser.toString(), "User set");
            }
        } else if (e.getActionCommand().equals("Create Account")) {
            LogWriter.log(Level.INFO, "Create new user", "");
            currentUser = AccountHandler.checkUser(username, password, e.getActionCommand());
		} else if (e.getActionCommand().equals("Check Out")) { 
            // TODO
            LogWriter.log(Level.INFO, "Check out", "");
        } else {
			LogWriter.log(Level.WARNING, "Unhandled Operation", e.getActionCommand());
		}
        return currentUser;
    }
    
}
