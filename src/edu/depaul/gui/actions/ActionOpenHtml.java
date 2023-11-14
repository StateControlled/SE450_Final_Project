package edu.depaul.gui.actions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.net.URI;

import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

import java.io.File;

public class ActionOpenHtml implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        openHtml(e);
    }

    private void openHtml(ActionEvent e) {
        try {
        	LogWriter.log(Level.INFO, "Opening ABOUT", "Open file.");
            File file = new File("about.html");
            URI location = file.toURI();
            Desktop.getDesktop().browse(location);
        } catch (Exception x) {
        	LogWriter.log(Level.SEVERE, "Failed to load ABOUT file.", x);
            x.printStackTrace();
        }
        
    }
}
