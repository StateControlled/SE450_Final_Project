package depaul.edu.Tests.ShoppingGuiIntermediate;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener {
    private static final int CONSTRAINT_INSET = 2;
    private final JLabel label = new JLabel("Actions");
    private JButton loginButton;

    public ControlPanel() {
        loginButton = new JButton("Log in");
        loginButton.addActionListener(this);

        setLayout(new GridBagLayout());

        add(label, setGridBagConstraints(0, 0, GridBagConstraints.CENTER));
        add(loginButton, setGridBagConstraints(0, 1, GridBagConstraints.CENTER));
    }

    public String getLabelText() {
        return label.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed.");
    }

    private GridBagConstraints setGridBagConstraints(int xCoordinate, int yCoordinate, int alignment) {
        GridBagConstraints constraints = new GridBagConstraints();
        int left = (xCoordinate != 0) ? 3 * CONSTRAINT_INSET : CONSTRAINT_INSET;
        constraints.gridx = xCoordinate;
        constraints.gridy = yCoordinate;
        constraints.insets = new Insets(CONSTRAINT_INSET, left, CONSTRAINT_INSET, CONSTRAINT_INSET);
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        constraints.anchor = alignment;
        return constraints;
    }

}
