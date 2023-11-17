package main.java.edu.depaul.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.edu.depaul.catalogue.Catalogue;
import main.java.edu.depaul.catalogue.OrderDatabase;
import main.java.edu.depaul.catalogue.UserDatabase;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;

public class ActionExit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        menuFileExitAction(e);
    }

    private void menuFileExitAction(ActionEvent e) {
        closeDatabases();
    	LogWriter.log(Level.INFO, "System shut down", "OFFLINE.");
        System.exit(0);
    }

    private void closeDatabases() {
        UserDatabase.getInstance();
        UserDatabase.close();
        LogWriter.log(Level.INFO, "Wrote User Database changes to file.", "Operation CLOSE");

        Catalogue.getInstance();
        Catalogue.close();
        LogWriter.log(Level.INFO, "Wrote Catalogue changes to file.", "Operation CLOSE");

        OrderDatabase.getInstance();
        OrderDatabase.close();
        LogWriter.log(Level.INFO, "Wrote Order Database changes to file.", "Operation CLOSE");
    }
}
