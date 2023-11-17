package main.java.edu.depaul.gui.actions;

import java.awt.event.ActionEvent;

import main.java.edu.depaul.customer.User;
import main.java.edu.depaul.gui.CheckOutScreen;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;

public class ButtonHandler {

    private ButtonHandler() {
        ;
    }

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
            if (currentUser == null) {
                LogWriter.log(Level.WARNING, "Cannot check out", "User is null");
                return null;
            }
            LogWriter.log(Level.INFO, "Check out", "");
            new CheckOutScreen(currentUser);
        } else {
			LogWriter.log(Level.WARNING, "Unhandled Operation", e.getActionCommand());
		}
        return currentUser;
    }
    
}
