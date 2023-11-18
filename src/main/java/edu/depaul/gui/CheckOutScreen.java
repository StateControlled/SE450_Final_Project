package main.java.edu.depaul.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.edu.depaul.catalogue.OrderDatabase;
import main.java.edu.depaul.customer.User;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;
import main.java.edu.depaul.order.Order;
import main.java.edu.depaul.paymentprocessor.PaymentProcessor;
import main.java.edu.depaul.shoppingcart.ShoppingCart;

public class CheckOutScreen {
    private JTextField creditCard = new JTextField();
    private JTextField expiration = new JTextField();
    private JTextField security = new JTextField();
    private JButton checkOutButton = new JButton("Check out");

    private JLabel cardLabel = new JLabel("Credit Card", SwingConstants.CENTER);
    private JLabel expirationLabel = new JLabel("Expiration", SwingConstants.CENTER);
    private JLabel securityLabel = new JLabel("CCV", SwingConstants.CENTER);
    private static JLabel priceLabel = new JLabel();
    
    public CheckOutScreen(User user) {
        LogWriter.log(Level.INFO, "Check Out Screen initialized", "CHECK OUT");
        init(user);
    }

    public void init(User user) {
        JFrame frame = new JFrame("Process Payment");
        frame.setMinimumSize(new Dimension(800, 200));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PaymentProcessor.validateCreditCard(creditCard.getText(), expiration.getText(), security.getText())) {
                    int confirm = JOptionPane.showOptionDialog(frame, "Credit Card approved\r\nYour order has shipped.\r\nThank you!", "Credit Card approved", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    user.getCart();

                    if (confirm == JOptionPane.YES_OPTION) {
                        LogWriter.log(Level.INFO, "CREATE ORDER", "Order confirmed");
                        OrderDatabase orderDatabase = OrderDatabase.getInstance();
                        
                        Order order = new Order(user, ShoppingCart.getShoppingList());
                        LogWriter.log(Level.INFO, "Added order " + order.getOrderID() + " to Order Database", "Database update");
                        JOptionPane.showMessageDialog(frame, String.format("Please save this information:\r\nOrder date: %s\r\nOrder number: %d", order.getOrderDate(), order.getOrderID()));

                        orderDatabase.addEntry(order);
                        user.addOrder(order.getOrderID());
                        user.clearCart();
                        frame.dispose();
                    } else {
                        LogWriter.log(Level.INFO, "Order Cancelled by client", "Order cancelled");
                        JOptionPane.showMessageDialog(frame, "Order cancelled.");
                        user.clearCart();
                        frame.dispose();
                    }
                } else {
                    LogWriter.log(Level.INFO, "Credit Card rejected", "Order refused");
                    JOptionPane.showMessageDialog(frame, "Credit Card Rejected");
                    user.clearCart();
                    frame.dispose();
                }
            }
            
        });

        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new GridLayout(3, 3));

        creditCard.setText("****************");
        expiration.setText("mm/yy");
        security.setText("CCV");
        user.getCart();
        priceLabel.setText(String.format("TOTAL $%,.2f", ShoppingCart.getTotal()));

        cardLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        expirationLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        securityLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        checkoutPanel.add(cardLabel);
        checkoutPanel.add(expirationLabel);
        checkoutPanel.add(securityLabel);
        checkoutPanel.add(creditCard);
        checkoutPanel.add(expiration);
        checkoutPanel.add(security);
        checkoutPanel.add(checkOutButton);
        checkoutPanel.add(priceLabel);

        frame.getContentPane().add(checkoutPanel);

        //frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void setPriceLabel(double price) {
        priceLabel.setText(String.format("TOTAL $%,.2f", price));
    }
}
