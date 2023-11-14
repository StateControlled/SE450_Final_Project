package edu.depaul.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.depaul.gui.actions.ActionAuthenticate;
import edu.depaul.item.AbstractItem;
import edu.depaul.item.factory.SuperFactory;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements GridBagConstraintsConstructor {
    private static final int CONSTRAINT_INSET = 2;
    private final JLabel label = new JLabel("Actions");
    private JTextField usernameField = new JTextField("username", 32);
    private JTextField passwordField = new JTextField("password", 32);
    private JButton loginButton;
    private JButton newUserButton;
    
    private DefaultListModel<AbstractItem> dataModel = new DefaultListModel<>();
    private JList<AbstractItem> cartItemList = new JList<>(dataModel);

    public ControlPanel() {
        loginButton = new JButton("Log in");
        newUserButton = new JButton("Create Account");
        
        loginButton.addActionListener(new ActionAuthenticate());
        newUserButton.addActionListener(new ActionAuthenticate());

        setLayout(new GridBagLayout());
        
        add(label, 			setGridBagConstraints(0, 0, 0.0, 0.0, 1, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        add(loginButton,	setGridBagConstraints(0, 1, 0.0, 0.0, 1, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        add(newUserButton, 	setGridBagConstraints(1, 1, 0.0, 0.0, 1, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        add(usernameField, 	setGridBagConstraints(0, 2, 0.0, 0.0, 2, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        add(passwordField, 	setGridBagConstraints(0, 3, 0.0, 0.0, 2, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        
        PanelScrollList cartWindow = new PanelScrollList(2);
        
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "Electric Violin", "Shar", 25000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLA", "Electric Viola", "Shar", 22000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "Electric Violin 2", "Shar", 25000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLA", "Electric Viola 2", "Shar", 22000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "Electric Violin 3", "Shar", 25000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLA", "Electric Viola 3", "Shar", 22000.0));
        
        JScrollPane scrollPane = new JScrollPane(cartWindow);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(scrollPane, setGridBagConstraints(0, 4, 0.0, 0.0, 2, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        
    } // END CONSTRUCTOR

    /**
     * 
     * @return	The content of the text fields "username" and "password" as an array.
     **/
    public String[] getTextFields() {
    	return new String[]{usernameField.getText(), passwordField.getText()};
    }
    
    public static GridBagConstraints setGridBagConstraints(int xCoordinate, int yCoordinate, double xWeight, double yWeight, 
    		int componentWidth, int componentHeight, int alignment, int inset, int fill) {
        GridBagConstraints constraints = new GridBagConstraints();
        int left = (xCoordinate != 0) ? 3 * inset : inset;
        constraints.gridx = xCoordinate;
        constraints.gridy = yCoordinate;
        constraints.insets = new Insets(inset, left, inset, inset);
        constraints.weightx = xWeight;
        constraints.weighty = yWeight;
        constraints.gridwidth = componentWidth;
        constraints.gridheight = componentHeight;
        constraints.anchor = alignment;
        constraints.fill = fill;
        return constraints;
    }
}
