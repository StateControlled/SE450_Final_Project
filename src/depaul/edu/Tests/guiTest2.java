package depaul.edu.Tests;

// Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;

public class guiTest2 {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(true);

        //Creating the MenuBar and adding components
        JMenuBar menubar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        JMenu helpMenu = new JMenu("Help");
        menubar.add(fileMenu);
        menubar.add(helpMenu);
        JMenuItem fileMenuOpen = new JMenuItem("Open");
        JMenuItem fileMenuSaveAs = new JMenuItem("Save as");
        fileMenu.add(fileMenuOpen);
        fileMenu.add(fileMenuSaveAs);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField textField = new JTextField(10); // accepts upto 10 characters
        JButton sendButton = new JButton("Send");
        JButton resetButton = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(sendButton);
        panel.add(resetButton);

        // Text Area at the Center
        JTextArea textArea = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);
    }
}
