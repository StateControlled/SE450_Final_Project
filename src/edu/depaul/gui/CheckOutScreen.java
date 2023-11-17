package edu.depaul.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;

import edu.depaul.catalogue.OrderDatabase;
import edu.depaul.customer.User;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;
import edu.depaul.order.Order;
import edu.depaul.paymentprocessor.PaymentProcessor;
import edu.depaul.shoppingcart.ShoppingCart;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                    int confirm = JOptionPane.showOptionDialog(frame, "Thank you!\r\nYour order has shipped.", "Credit Card approved", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (confirm == JOptionPane.YES_OPTION) {
                        LogWriter.log(Level.INFO, "CREATE ORDER", "Order confirmed");
                        OrderDatabase od = OrderDatabase.getInstance();
                        user.getCart();
                        od.addEntry(new Order(user, ShoppingCart.getShoppingList()));
                        frame.dispose();
                    }
                }
            }
            
        });

        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new GridLayout(3, 3));

        creditCard.setText("****************");
        expiration.setText("mm/yy");
        security.setText("ccv");
        priceLabel.setText(String.format("TOTAL $%,.2f", user.getCart().getTotal()));

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
