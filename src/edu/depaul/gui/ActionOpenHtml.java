package edu.depaul.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.net.URI;
import java.io.File;

public class ActionOpenHtml implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        openHtml(e);
    }

    private void openHtml(ActionEvent e) {
        try {
            File file = new File("about.html");
            URI location = file.toURI();
            Desktop.getDesktop().browse(location);
        } catch (Exception x) {
            x.printStackTrace();
        }
        
    }
}
