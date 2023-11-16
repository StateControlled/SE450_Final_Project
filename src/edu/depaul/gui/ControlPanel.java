package edu.depaul.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JList;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;
import javax.swing.JTextField;
//import javax.swing.ScrollPaneConstants;

import edu.depaul.customer.User;
import edu.depaul.handlers.AccountHandler;
//import edu.depaul.item.AbstractItem;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener, GridBagConstraintsConstructor {
    private static final int CONSTRAINT_INSET = 2;
    private final JLabel label = new JLabel("Actions");
    private JLabel message = new JLabel("********");
    private JTextField usernameField = new JTextField("username", 32);
    private JTextField passwordField = new JTextField("password", 32);
    private JButton loginButton;
    private JButton newUserButton;
    private JButton checkOutButton;
    private boolean userAuthenticated = false;

    //private static DefaultListModel<AbstractItem> dataModel = new DefaultListModel<>();
    //private static JList<AbstractItem> cartItemList = new JList<>(dataModel);

    
    /**The user that is currently logged into the application**/
    private static User currentUser;
    /**List to display items in cart**/
    //private static PanelScrollList cartWindow = new PanelScrollList(2);

    // public static void addItemToCart(AbstractItem item) {
    //     cartWindow.addItemToScrollList(item, false);
    //     dataModel.addElement(item);
    // }

    public ControlPanel() {
        this.setBounds(0, 0, 400, 800);
        loginButton = new JButton("Log in");
        newUserButton = new JButton("Create Account");
        checkOutButton = new JButton("Check Out");
        
        loginButton.addActionListener(this);
        newUserButton.addActionListener(this);
        checkOutButton.addActionListener(this);

        label.setBounds(72, 0, 256, 72);
        message.setBounds(72, 80, 256, 72);

        loginButton.setBounds(16, 160, 128, 72);
        
        newUserButton.setBounds(160, 160, 128, 72);
        checkOutButton.setBounds(304, 160, 128, 72);

        this.add(label);
        this.add(message);
        this.add(loginButton);
        this.add(newUserButton);
        this.add(checkOutButton);

        this.setPreferredSize(new Dimension(400, 800));

        // setLayout(new GridBagLayout());
        
        // add(label, 			setGridBagConstraints(0, 0, 0.0, 0.0, 3, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        // add(message, 		setGridBagConstraints(0, 1, 0.0, 0.0, 3, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        
        // add(loginButton,	setGridBagConstraints(0, 2, 0.0, 0.0, 1, 1, GridBagConstraints.WEST, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        // add(newUserButton, 	setGridBagConstraints(1, 2, 0.0, 0.0, 1, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        
        // add(usernameField, 	setGridBagConstraints(0, 3, 0.0, 0.0, 3, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        // add(passwordField, 	setGridBagConstraints(0, 4, 0.0, 0.0, 3, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        
        //PanelScrollList cartWindow = new PanelScrollList(2);

        //JScrollPane scrollPane = new JScrollPane(cartWindow);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        //cartItemList.setCellRenderer(new ScrollListRenderer());
        //cartItemList.setPrototypeCellValue(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "LONG FORM DESCRIPTION", "MANUFACTURER NAME", 10000000.00));
        //cartItemList.setVisibleRowCount(2);
        
        //add(scrollPane,     setGridBagConstraints(0, 5, 0.0, 0.0, 3, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        //add(checkOutButton, setGridBagConstraints(1, 6, 0.0, 0.0, 1, 1, GridBagConstraints.CENTER, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        
    } // END CONSTRUCTOR

    /**
     * @return	The content of the text fields "username" and "password" as an array.
     **/
    // public String[] getTextFields() {
    // 	return new String[]{usernameField.getText(), passwordField.getText()};
    // }

    public static void setUser(User user) {
        currentUser = user;
    }

    public static User getUser() {
        return currentUser;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        // TODO implement check out and cart(?)
		if (e.getActionCommand().equals("Log in") || e.getActionCommand().equals("Create Account")) {
			LogWriter.log(Level.INFO, "Control Panel Button Press", e.getActionCommand());
            LogWriter.log(Level.INFO, String.format("READ: %s, %s", usernameField.getText(), passwordField.getText()), e.getActionCommand());
            currentUser = AccountHandler.checkUser(usernameField.getText(), passwordField.getText(), e.getActionCommand());
            if (currentUser != null) {
                userAuthenticated = true;
                LogWriter.log(Level.INFO, currentUser.toString(), "User set");
                message.setText("Welcome " + currentUser.getName() + "!");
            }
		//} else if (e.getActionCommand().equals("Check Out")) { 

        } else {
			LogWriter.log(Level.WARNING, "Unhandled Operation", e.getActionCommand());
		}
        LogWriter.log(Level.INFO, "Control Panel received user authentication as " + userAuthenticated, "AUTHENTICATION EVENT");
        passwordField.setText("********");
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
