package edu.depaul.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

public class ActionExit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        menuFileExitAction(e);
    }

    private void menuFileExitAction(ActionEvent e) {
    	LogWriter.log(Level.INFO, "System shut down", "OFFLINE.");
        System.exit(0);
    }
}
