package depaul.edu.Tests.GUITest;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import depaul.edu.Item.IAbstractItem;
import depaul.edu.Item.ItemFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Based on example from https://stackoverflow.com/questions/33894580/scrollable-list-with-items-of-set-pixel-height-in-java-swing
 * Modified by WB
 */
public class GUITest3 extends JPanel {
    private static final File CATALOGUE_FILE = new File("src\\depaul\\edu\\Catalogue\\products.csv");
    private static final int INIT_MAX_ROWS = 8;
    private DefaultListModel<IAbstractItem> dataModel = new DefaultListModel<>();
    private JList<IAbstractItem> guiItemList = new JList<>(dataModel); // The object that will display the list of items

    public GUITest3() {
        ScrollListComponent dataPanel = new ScrollListComponent(INIT_MAX_ROWS);

        try (BufferedReader reader = new BufferedReader(new FileReader(CATALOGUE_FILE))) {
            String line;
            while ( (line = reader.readLine()) != null ) {
                String[] record = line.split(",");
                IAbstractItem item = ItemFactory.createProduct(record[0], record[1], record[2], Double.parseDouble(record[3]));
                dataPanel.addItem(item);
                dataModel.addElement(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
            e.printStackTrace(); 
            System.exit(-2);          
        } catch (Exception e) {
            System.out.println("A exception has occurred and the program ended.");
            System.out.println("MESSAGE : " + e.getMessage());
            e.printStackTrace();
            System.exit(-3);
        }

        JScrollPane scrollPane1 = new JScrollPane(dataPanel);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane1);
        guiItemList.setVisibleRowCount(INIT_MAX_ROWS);
        guiItemList.setCellRenderer(new GuiRenderComponent());

        guiItemList.setPrototypeCellValue(ItemFactory.createProduct("Instrument", "Long Form Description", "Manufacturer Name", 1000000.00));

        /***********************************************************/
        //JScrollPane scrollPane2 = new JScrollPane(guiItemList);
        //scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //add(scrollPane2);

    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("GUI Test 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUITest3());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        System.out.println("GUI TEST");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
