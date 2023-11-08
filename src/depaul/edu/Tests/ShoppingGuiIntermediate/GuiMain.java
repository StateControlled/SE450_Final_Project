package depaul.edu.Tests.ShoppingGuiIntermediate;

import java.awt.GridBagConstraints;
//import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import depaul.edu.Catalogue.Catalogue;
import depaul.edu.Item.IAbstractItem;
import depaul.edu.Item.ItemFactory;

public class GuiMain extends JPanel {
    private static final int INIT_MAX_ROWS = 8;
    private static final int CONSTRAINT_INSET = 2;
    private DefaultListModel<IAbstractItem> dataModel = new DefaultListModel<>();
    private JList<IAbstractItem> guiItemList = new JList<>(dataModel);

    public static void main(String[] args) {
        // log startup
        System.out.println("STARTUP INITIATED");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        System.out.println("THIS IS A TEST: GUI TEST 4");
        JFrame frame = new JFrame("FINAL PROJECT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GuiMain main = new GuiMain();
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionExit());
        fileMenu.add(exit);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionOpenHtml());
        helpMenu.add(about);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        ControlPanel panel = new ControlPanel();

        //frame.setLayout(new GridBagLayout());
        //frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        //frame.getContentPane().add(BorderLayout.CENTER, main);
        //frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setLayout(new GridBagLayout());
        frame.add(menuBar, setGridBagConstraints(0, 0, 0, 0, 2, 1, GridBagConstraints.BASELINE_LEADING));
        frame.add(main, setGridBagConstraints(0, 1, 0, 0, 1, 1, GridBagConstraints.BASELINE_LEADING));
        frame.add(panel, setGridBagConstraints(1, 1, 0, 0, 1, 1, GridBagConstraints.BASELINE_LEADING));

        frame.pack();

        //frame.setSize(main.getSize().width + panel.getSize().width, main.getSize().height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public GuiMain() {
        System.out.println("SETTING UP...");
        PanelScrollList scrollList = new PanelScrollList(INIT_MAX_ROWS);

        Catalogue.getInstance();
        ArrayList<IAbstractItem> items = Catalogue.getCatalogueAsList();

        System.out.println("READING CATALOGUE");
        //System.out.println(Catalogue.getFilePath(false));
        //System.out.println(Catalogue.getFilePath(true));

        for (IAbstractItem i : items) {
            scrollList.addItemToScrollList(i);
            dataModel.addElement(i);
        }

        JScrollPane scrollPane = new JScrollPane(scrollList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);
        
        guiItemList.setVisibleRowCount(INIT_MAX_ROWS);
        guiItemList.setCellRenderer(new ScrollListRenderer());
        guiItemList.setPrototypeCellValue(ItemFactory.createProduct("VIOLIN", "LONG FORM DESCRIPTION", "MANUFACTURER NAME", 10000000.00));
    }

    private static GridBagConstraints setGridBagConstraints(int xCoordinate, int yCoordinate, double xWeight, double yWeight, int componentWidth, int componentHeight, int alignment) {
        GridBagConstraints constraints = new GridBagConstraints();
        int left = (xCoordinate != 0) ? 3 * CONSTRAINT_INSET : CONSTRAINT_INSET;
        constraints.gridx = xCoordinate;
        constraints.gridy = yCoordinate;
        constraints.insets = new Insets(CONSTRAINT_INSET, left, CONSTRAINT_INSET, CONSTRAINT_INSET);
        constraints.weightx = xWeight;
        constraints.weighty = yWeight;
        constraints.gridwidth = componentWidth;
        constraints.gridheight = componentHeight;
        constraints.anchor = alignment;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return constraints;
    }
}
