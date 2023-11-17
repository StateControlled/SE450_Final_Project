package edu.depaul.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import edu.depaul.catalogue.Catalogue;
import edu.depaul.customer.User;
import edu.depaul.gui.actions.ActionExit;
import edu.depaul.gui.actions.ActionOpenHtml;
import edu.depaul.gui.actions.ButtonHandler;
import edu.depaul.item.AbstractItem;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;
import edu.depaul.shoppingcart.ShoppingCart;

public class Application {
    private final JLabel label = new JLabel("SHOPPING", SwingConstants.CENTER);
    private JLabel message = new JLabel("********", SwingConstants.CENTER);
    private static JLabel cartTotalLabel = new JLabel("Cart total : $0.0", SwingConstants.CENTER);
    private JTextField usernameField = new JTextField("username", 32);
    private JTextField passwordField = new JTextField("password", 32);
    private JButton loginButton;
    private JButton newUserButton;
    private JButton checkOutButton;
    private boolean userAuthenticated = false;
    
    private static User currentUser;

    public Application() {
        LogWriter.log(Level.INFO, "Initializing GUI", "Initialization");
        init();
    }

    public void init() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1200, 700);
        frame.setMinimumSize(new Dimension(1200, 700));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // using default list model to display items in catalogue
        DefaultListModel<AbstractItem> modelListLeft = new DefaultListModel<>();
        DefaultListModel<AbstractItem> modelListRight = new DefaultListModel<>();

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        //
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem menuExitOption = new JMenuItem("Exit");
        menuExitOption.addActionListener(new ActionExit());
        fileMenu.add(menuExitOption);

        //
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionOpenHtml());
        helpMenu.add(about);

        //
        JList<AbstractItem> listLeft = new JList<>();
        JList<AbstractItem> listRight = new JList<>();        

        JButton removeButton = new JButton("<< REMOVE");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listRight.getSelectedValuesList().stream().forEach((data) -> {
                    modelListRight.removeElement(data);
                });
                listLeft.revalidate();
                listRight.revalidate();
            }
        }); 

        removeButton.setBounds(360, 120, 128, 64);
        frame.getContentPane().add(removeButton);

        //
        JButton addButton = new JButton("ADD >>");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userAuthenticated) {
                    listLeft.getSelectedValuesList().stream().forEach((data) -> {
                        modelListRight.addElement(data);
                    });
                } else {
                    LogWriter.log(Level.WARNING, "Cannot add to cart", "No User logged in");
                }
                listLeft.revalidate();
                listRight.revalidate();
            }
        });

        addButton.setBounds(360, 50, 128, 64);
        frame.getContentPane().add(addButton);

        listLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listLeft.setModel(modelListLeft);
        JScrollPane scrollListLeft = new JScrollPane(listLeft);
        scrollListLeft.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel leftScrollPanel = new JPanel();
        leftScrollPanel.setSize(new Dimension(350, 800));
        leftScrollPanel.setBounds(0, 50, 350, 800);
        leftScrollPanel.add(scrollListLeft);
        
        frame.add(leftScrollPanel);
        
        listRight.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listRight.setModel(modelListRight);   
        JScrollPane scrollListRight = new JScrollPane(listRight);
        scrollListRight.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel rightScrollPanel = new JPanel();
        rightScrollPanel.setSize(new Dimension(350, 800));
        rightScrollPanel.setBounds(500, 50, 350, 800);
        rightScrollPanel.add(scrollListRight);
        frame.add(rightScrollPanel);

        // Add items to list
        Catalogue c = Catalogue.getInstance();
        ArrayList<AbstractItem> items = c.getCatalogue();  
        
        for (AbstractItem i : items) {
            modelListLeft.addElement(i);
        }

        loginButton = new JButton("Log in");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser = ButtonHandler.actionPerformed(e, currentUser, usernameField.getText(), passwordField.getText());
                passwordField.setText("********");
                if (currentUser != null) {
                    userAuthenticated = true;
                    message.setText("Welcome " + currentUser.getName() + "!");
                }
                LogWriter.log(Level.INFO, "Control Panel received user authentication as " + userAuthenticated, "AUTHENTICATION EVENT");
                
            }
        });

        newUserButton = new JButton("Create Account");
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser = ButtonHandler.actionPerformed(e, currentUser, usernameField.getText(), passwordField.getText());
                passwordField.setText("********");
                if (currentUser != null) {
                    userAuthenticated = true;
                    message.setText("Welcome " + currentUser.getName() + "!");
                }
                LogWriter.log(Level.INFO, "Control Panel received user authentication as " + userAuthenticated, "AUTHENTICATION EVENT");
            }
        });

        checkOutButton = new JButton("Check Out");
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUser != null) {
                    currentUser.getCart();
                    ShoppingCart.getInstance();

                    int j = modelListRight.getSize();
                    for (int i = 0; i < j; i++) {
                        ShoppingCart.addToCart(modelListRight.get(i));
                    }

                    ButtonHandler.actionPerformed(e, currentUser, usernameField.getText(), passwordField.getText());
                    LogWriter.log(Level.INFO, "Check out successful!", "CHECK OUT EVENT");
                } else {
                    LogWriter.log(Level.WARNING, "Cannot check out.", "User is null");
                }
            }
        });

        label.setBounds(850, 0, 336, 72);
        label.setFont(new Font("Serif", Font.BOLD, 36));
        message.setBounds(850, 80, 336, 72);
        message.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        message.setFont(new Font("Serif", Font.PLAIN, 28));
        cartTotalLabel.setBounds(500, 0, 350, 40);
        cartTotalLabel.setFont(new Font("Serif", Font.PLAIN, 28));

        loginButton.setBounds(850, 160, 100, 36);
        newUserButton.setBounds(952, 160, 128, 36);
        checkOutButton.setBounds(1080, 160, 100, 36);

        usernameField.setBounds(850, 240, 256, 40);
        passwordField.setBounds(850, 284, 256, 40);

        frame.getContentPane().add(label);
        frame.getContentPane().add(message);
        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(newUserButton);
        frame.getContentPane().add(checkOutButton);
        frame.getContentPane().add(usernameField);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(cartTotalLabel);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    } 

    public static User getUser() {
        return currentUser;
    }

    public static void setUser(User newUser) {
        currentUser = newUser;
    }

    public static void setCartTotalLabel(double total) {
        cartTotalLabel.setText(String.format("Cart total : $,.2f", total));
    }
}
