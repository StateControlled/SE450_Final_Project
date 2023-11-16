package edu.depaul.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;

import edu.depaul.catalogue.Catalogue;
import edu.depaul.gui.actions.ActionExit;
import edu.depaul.item.AbstractItem;
import edu.depaul.logwriter.LogWriter;

public class Application {

    static {
        LogWriter.getLogWriter("New Application");
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application();
            }
        });
    }   

    public Application() {
        initialize();
    }

    public void initialize() {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 1200, 800);
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
                    modelListLeft.addElement(data);
                    modelListRight.removeElement(data);
                });
                listLeft.revalidate();
                listRight.revalidate();
            }
        }); 

        removeButton.setBounds(300, 400, 128, 64);
        frame.getContentPane().add(removeButton);

        JButton addButton = new JButton("ADD >>");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get list of selected values and for each one of them do following
                listLeft.getSelectedValuesList().stream().forEach((data) -> {
                    // moving data
                    modelListRight.addElement(data);
                    // remove from other side
                    modelListLeft.removeElement(data);
                });
                // refreshing the view after changes
                listLeft.revalidate();
                listRight.revalidate();
            }
        });

        addButton.setBounds(300, 200, 128, 64);
        frame.getContentPane().add(addButton);

        listLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listLeft.setBounds(0, 0, 300, 800);
        listLeft.setModel(modelListLeft);
        frame.getContentPane().add(listLeft);

        listRight.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listRight.setBounds(500, 0, 300, 800);
        listRight.setModel(modelListRight);
        frame.getContentPane().add(listRight);                

        // Add items to list
        Catalogue c = Catalogue.getInstance();
        ArrayList<AbstractItem> items = c.getCatalogue();  
        
        for (AbstractItem i : items) {
            modelListLeft.addElement(i.view());
        }

        frame.setVisible(true);
    } 
}
