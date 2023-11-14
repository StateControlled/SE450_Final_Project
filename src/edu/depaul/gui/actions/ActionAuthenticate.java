package edu.depaul.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.depaul.authenticator.Authenticator;
import edu.depaul.customer.User;
import edu.depaul.gui.ControlPanel;

/**
 * This class is designed to connect with the login button and will authenticate a user.
 **/
public class ActionAuthenticate implements ActionListener {
//	private User user;
//	private String username;
//	private String password;
//	private ControlPanel origin;
		
	public ActionAuthenticate() {
		;
	}
	
	/**
	 * Detects when a button is clicked.
	 **/
	@Override
	public void actionPerformed(ActionEvent e) {
//		username = origin.getTextFields()[0];
//		password = origin.getTextFields()[1];
		System.out.println("ActionAuthenticate called");
		System.out.println("SOURCE " + e.getSource());
		System.out.println("COMMAND " + e.getActionCommand());
//		authenticate();
	}

	public boolean authenticate() {
		// TODO implement or remove
		//Authenticator.validateCustomerPassword(user, password);
		return false;
	}
	
}
