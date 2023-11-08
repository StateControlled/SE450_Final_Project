package depaul.edu.Tests.ShoppingGuiIntermediate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionExit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        menuFileExitActionPerformed(e);
    }

    private void menuFileExitActionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
