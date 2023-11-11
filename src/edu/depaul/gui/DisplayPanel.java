package edu.depaul.gui;

import java.awt.Color;
//import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.depaul.item.AbstractItem;

public class DisplayPanel extends JPanel {
    private static final int CONSTRAINT_INSET = 2;

    private AbstractItem itemData;
    private JLabel itemNameLabel = new JLabel();
    private JLabel itemManufacturerLabel = new JLabel();
    private JLabel itemPriceLabel = new JLabel();

    /**
     * Constructor
     **/
    public DisplayPanel() {
        // Required to make Renderer class work.
        // Each DisplayPanel has its own internal grid layout.
        setLayout(new GridBagLayout());

        add(new JLabel("Item description :"), setGridBagConstraints(0, 0, GridBagConstraints.BASELINE_TRAILING));
        add(itemNameLabel, setGridBagConstraints(1, 0, GridBagConstraints.BASELINE_LEADING));

        add(new JLabel("Manufacturer :"), setGridBagConstraints(0, 1, GridBagConstraints.BASELINE_TRAILING));
        add(itemManufacturerLabel, setGridBagConstraints(1, 1, GridBagConstraints.BASELINE_LEADING));

        add(new JLabel("Item price :"), setGridBagConstraints(0, 2, GridBagConstraints.BASELINE_TRAILING));
        add(itemPriceLabel, setGridBagConstraints(1, 2, GridBagConstraints.BASELINE_LEADING));

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * Constructs a new DisplayPanel object and initializes data.
     **/
    public DisplayPanel(AbstractItem item) {
        this();
        setData(item);
        //setPreferredSize(new Dimension(200, 60));
    }

    /**
     * Sets class variables to match those of the item
     * @param item  the item
     **/
    public final void setData(AbstractItem item) {
        this.itemData = item;
        itemNameLabel.setText(item.getItemName());
        itemManufacturerLabel.setText(item.getManufacturer());
        itemPriceLabel.setText(String.format("$%,.2f", item.getPrice()));
        this.setToolTipText(item.getItemName());
    }

    public AbstractItem getData() {
        return itemData;
    }

    private GridBagConstraints setGridBagConstraints(int xCoordinate, int yCoordinate, int alignment) {
        GridBagConstraints constraints = new GridBagConstraints();
        int left = (xCoordinate != 0) ? 3 * CONSTRAINT_INSET : CONSTRAINT_INSET;
        constraints.gridx = xCoordinate;
        constraints.gridy = yCoordinate;
        constraints.insets = new Insets(CONSTRAINT_INSET, left, CONSTRAINT_INSET, CONSTRAINT_INSET);
        //constraints.insets.left = (xCoordinate != 0) ? 3 * CONSTRAINT_INSET : CONSTRAINT_INSET;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        constraints.anchor = alignment;
        //constraints.fill = GridBagConstraints.BOTH;
        //constraints.anchor = (xCoordinate == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        //constraints.fill = (xCoordinate == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;
        return constraints;
    }

}
