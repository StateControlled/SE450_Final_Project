package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemTransferApp extends JFrame {

    private DefaultListModel<String> sourceListModel;
    private DefaultListModel<String> targetListModel;

    public ItemTransferApp() {
        setTitle("Item Transfer App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        sourceListModel = new DefaultListModel<>();
        targetListModel = new DefaultListModel<>();

        sourceListModel.addElement("Item 1");
        sourceListModel.addElement("Item 2");
        sourceListModel.addElement("Item 3");
        sourceListModel.addElement("Item 4");
        sourceListModel.addElement("Item 5");
        sourceListModel.addElement("Item 6");
        sourceListModel.addElement("Item 7");
        sourceListModel.addElement("Item 8");

        // Create source list and scroll pane
        JList<String> sourceList = new JList<>(sourceListModel);
        JScrollPane sourceScrollPane = new JScrollPane(sourceList);

        // Create target list and scroll pane
        JList<String> targetList = new JList<>(targetListModel);
        JScrollPane targetScrollPane = new JScrollPane(targetList);

        // Create buttons for transferring items
        JButton transferButton = new JButton("Transfer >>");
        JButton removeButton = new JButton("<< Remove");

        // Add action listeners to the buttons
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferItem(sourceList, targetListModel);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferItem(targetList, sourceListModel);
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(transferButton);
        buttonPanel.add(removeButton);

        // Create the main content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(sourceScrollPane, BorderLayout.WEST);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);
        contentPanel.add(targetScrollPane, BorderLayout.EAST);

        // Set the content pane of the frame
        setContentPane(contentPanel);
    }

    private void transferItem(JList<String> sourceList, DefaultListModel<String> targetListModel) {
        // Get selected item from the source list
        String selectedItem = sourceList.getSelectedValue();

        // Transfer the item to the target list
        if (selectedItem != null) {
            targetListModel.addElement(selectedItem);
            sourceListModel.removeElement(selectedItem);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ItemTransferApp app = new ItemTransferApp();
                app.setVisible(true);
            }
        });
    }
}

