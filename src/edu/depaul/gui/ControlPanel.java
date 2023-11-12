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
public class ControlPanel extends JPanel implements ActionListener, GridBagConstraintsConstructor {
    private static final int CONSTRAINT_INSET = 2;
    private final JLabel label = new JLabel("Actions");
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    
    private DefaultListModel<AbstractItem> dataModel = new DefaultListModel<>();
    private JList<AbstractItem> cartItemList = new JList<>(dataModel);

    public ControlPanel() {
        loginButton = new JButton("Log in");
        usernameField = new JTextField("username", 32);
        passwordField = new JTextField("password", 32);
        loginButton.addActionListener(new ActionAuthenticate());
        //

        setLayout(new GridBagLayout());

        add(label, setGridBagConstraints(0, 0, GridBagConstraints.CENTER));
        add(loginButton, setGridBagConstraints(0, 1, GridBagConstraints.CENTER));
        add(usernameField, setGridBagConstraints(0, 2, GridBagConstraints.CENTER));
        add(passwordField, setGridBagConstraints(0, 3, GridBagConstraints.CENTER));
        
        PanelScrollList cartWindow = new PanelScrollList(2);
        
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "Electric Violin", "Shar", 25000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLA", "Electric Viola", "Shar", 22000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "Electric Violin 2", "Shar", 25000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLA", "Electric Viola 2", "Shar", 22000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "Electric Violin 3", "Shar", 25000.0));
        cartWindow.addItemToScrollList(SuperFactory.createProduct("INSTRUMENT", "VIOLA", "Electric Viola 3", "Shar", 22000.0));
        
        JScrollPane scrollPane = new JScrollPane(cartWindow);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(scrollPane, setGridBagConstraints(0, 4, GridBagConstraints.CENTER));
        
    }

    public String getLabelText() {
        return label.getText();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		//usernameField.getText(), passwordField.getText()
		
	}

}
