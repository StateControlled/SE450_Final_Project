package edu.depaul.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import edu.depaul.catalogue.Catalogue;
import edu.depaul.customer.User;
import edu.depaul.gui.actions.ActionExit;
import edu.depaul.handlers.ButtonHandler;
import edu.depaul.item.AbstractItem;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

public class Application {
    private final JLabel label = new JLabel("Actions");
    private JLabel message = new JLabel("********");
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
        frame.setBounds(100, 100, 1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //String[] values = new String[]{"Case", "Motherboard", "CPU", "RAM", "GPU", "HDD", "PSU"};
        String[] values = new String[256];

        for (int i = 0; i < values.length; i++) {
            values[i] = String.format("Item %d Test Line", i + 1);
        }

        // using default list model.
        DefaultListModel<String> modelListLeft = new DefaultListModel<>();
        DefaultListModel<String> modelListRight = new DefaultListModel<>();

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem menuExitOption = new JMenuItem("Exit");
        menuExitOption.addActionListener(new ActionExit());
        fileMenu.add(menuExitOption);
        frame.getContentPane().setLayout(null);

        JList<String> listLeft = new JList<>();
        JList<String> listRight = new JList<>();

        JButton removeButton = new JButton("<< REMOVE");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listRight.getSelectedValuesList().stream().forEach((data) -> {
                    //modelListLeft.addElement(data);
                    modelListRight.removeElement(data);
                });
                listLeft.revalidate();
                listRight.revalidate();
            }
        }); 

        removeButton.setBounds(360, 400, 128, 64);
        frame.getContentPane().add(removeButton);

        JButton addButton = new JButton("ADD >>");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get list of selected values and for each one of them do following
                listLeft.getSelectedValuesList().stream().forEach((data) -> {
                    modelListRight.addElement(data);
                    //modelListLeft.removeElement(data);
                });
                // refresh the view after changes
                listLeft.revalidate();
                listRight.revalidate();
            }
        });

        addButton.setBounds(360, 200, 128, 64);
        frame.getContentPane().add(addButton);

        listLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listLeft.setBounds(0, 0, 350, 800);
        listLeft.setModel(modelListLeft);
        frame.getContentPane().add(listLeft);

        listRight.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listRight.setBounds(500, 0, 350, 800);
        listRight.setModel(modelListRight);
        frame.getContentPane().add(listRight);            
        
        //ControlPanel controls = new ControlPanel();
        //controls.setBounds(800, 0, 400, 800);
        //controls.setPreferredSize(new Dimension(400, 800));
        //frame.getContentPane().add(controls);

        // Add items to list
        Catalogue c = Catalogue.getInstance();
        ArrayList<AbstractItem> items = c.getCatalogue();  
        
        for (AbstractItem i : items) {
            modelListLeft.addElement(i.view());
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
                ButtonHandler.actionPerformed(e, currentUser, usernameField.getText(), passwordField.getText());
                LogWriter.log(Level.INFO, "Control Panel received user authentication as " + userAuthenticated, "AUTHENTICATION EVENT");
            }
        });
        
        //loginButton.addActionListener(this);
        //newUserButton.addActionListener(this);
        //checkOutButton.addActionListener(this);

        label.setBounds(948, 0, 256, 72);
        label.setFont(new Font("Serif", Font.BOLD, 36));
        message.setBounds(948, 80, 256, 72);
        message.setFont(new Font("Serif", Font.PLAIN, 28));

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

        frame.setResizable(false);
        frame.setVisible(true);
    } 

    public static User getUser() {
        return currentUser;
    }

    public static void setUser(User newUser) {
        currentUser = newUser;
    }
}
