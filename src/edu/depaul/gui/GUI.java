package edu.depaul.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.depaul.catalogue.Catalogue;
import edu.depaul.gui.actions.ActionExit;
import edu.depaul.gui.actions.ActionOpenHtml;
import edu.depaul.item.AbstractItem;
import edu.depaul.item.factory.SuperFactory;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;
import edu.depaul.resources.constants.StorageFiles;

@SuppressWarnings("serial")
public class GUI extends JPanel implements GridBagConstraintsConstructor {
    private File catalogueFile = StorageFiles.CATALOGUE_SOURCE;
    private static final int INIT_MAX_ROWS = 8;
    private static final int CONSTRAINT_INSET = 2;
    private DefaultListModel<AbstractItem> dataModel = new DefaultListModel<>();
    private JList<AbstractItem> guiItemList = new JList<>(dataModel);
    
    public static void createAndShowGUI() {
    	LogWriter.getLogWriter(StorageFiles.LOG_NAME);
    	LogWriter.log(Level.INFO, "Starting GUI", "Init GUI");
    	
        JFrame frame = new JFrame("FINAL PROJECT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI main = new GUI();
        
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

        frame.setLayout(new GridBagLayout());
        frame.add(menuBar,  setGridBagConstraints(0, 0, 0, 0, 2, 1, GridBagConstraints.BASELINE_LEADING));
        frame.add(main,     setGridBagConstraints(0, 1, 0, 0, 1, 1, GridBagConstraints.BASELINE_LEADING));
        frame.add(panel,    setGridBagConstraints(1, 1, 0, 0, 1, 1, GridBagConstraints.BASELINE_LEADING));

        frame.pack();

        //frame.setSize(main.getSize().width + panel.getSize().width, main.getSize().height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Constructor.
     **/
    public GUI() {
        PanelScrollList scrollList = new PanelScrollList(INIT_MAX_ROWS);
        Catalogue catalogue = Catalogue.getInstance();
        ArrayList<AbstractItem> items = catalogue.readFromFile(catalogueFile);

        for (AbstractItem i : items) {
            scrollList.addItemToScrollList(i);
            dataModel.addElement(i);
        }

        JScrollPane scrollPane = new JScrollPane(scrollList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);
        
        guiItemList.setVisibleRowCount(INIT_MAX_ROWS);
        guiItemList.setCellRenderer(new ScrollListRenderer());
        guiItemList.setPrototypeCellValue(SuperFactory.createProduct("INSTRUMENT", "VIOLIN", "LONG FORM DESCRIPTION", "MANUFACTURER NAME", 10000000.00));
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
