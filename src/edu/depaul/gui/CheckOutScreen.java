package edu.depaul.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.depaul.customer.User;

public class CheckOutScreen {
    private JTextField creditCard = new JTextField();
    private JTextField expiration = new JTextField();
    private JTextField security = new JTextField();

    private JLabel c = new JLabel("Credit Card", SwingConstants.CENTER);
    private JLabel e = new JLabel("Expiration", SwingConstants.CENTER);
    private JLabel s = new JLabel("CCV", SwingConstants.CENTER);
    
    public CheckOutScreen(User user) {
        init(user);
    }

    public void init(User user) {
        JFrame frame = new JFrame("Check out");
        frame.setBounds(0, 0, 800, 800);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setBounds(0, 0, 200, 30);
        e.setBounds(250, 0, 100, 30);
        s.setBounds(400, 0, 100, 30);

        creditCard.setText("****************");
        expiration.setText("dd/mm");
        security.setText("ccv");

        creditCard.setBounds(0, 40, 200, 30);
        expiration.setBounds(250, 40, 100, 30);
        security.setBounds(400, 40, 100, 30);

        c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        e.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        s.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frame.getContentPane().add(c);
        frame.getContentPane().add(e);
        frame.getContentPane().add(s);
        frame.getContentPane().add(creditCard);
        frame.getContentPane().add(expiration);
        frame.getContentPane().add(security);

        //frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
