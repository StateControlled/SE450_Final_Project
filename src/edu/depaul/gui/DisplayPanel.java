package edu.depaul.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.depaul.item.AbstractItem;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel implements GridBagConstraintsConstructor {
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

        add(new JLabel("Item description :"), setGridBagConstraints(0, 0, 0.0, 0.0, 1, 1, GridBagConstraints.BASELINE_TRAILING, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        add(itemNameLabel, setGridBagConstraints(1, 0, 0.0, 0.0, 1, 1, GridBagConstraints.BASELINE_LEADING, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));

        add(new JLabel("Manufacturer :"), setGridBagConstraints(0, 1, 0.0, 0.0, 1, 1, GridBagConstraints.BASELINE_TRAILING, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        add(itemManufacturerLabel, setGridBagConstraints(1, 1, 0.0, 0.0, 1, 1, GridBagConstraints.BASELINE_LEADING, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));

        add(new JLabel("Item price :"), setGridBagConstraints(0, 2, 0.0, 0.0, 1, 1, GridBagConstraints.BASELINE_TRAILING, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));
        add(itemPriceLabel, setGridBagConstraints(1, 2, 0.0, 0.0, 1, 1, GridBagConstraints.BASELINE_LEADING, CONSTRAINT_INSET, GridBagConstraints.HORIZONTAL));

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * Constructs a new DisplayPanel object and initializes data.
     **/
    public DisplayPanel(AbstractItem item) {
        this();
        setData(item);
        this.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.println(itemData.view());
        	}
        });
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
    
    public static GridBagConstraints setGridBagConstraints(int xCoordinate, int yCoordinate, double xWeight, double yWeight, 
    		int componentWidth, int componentHeight, int alignment, int inset, int fill) {
        GridBagConstraints constraints = new GridBagConstraints();
        int left = (xCoordinate != 0) ? 3 * inset : inset;
        constraints.gridx = xCoordinate;
        constraints.gridy = yCoordinate;
        constraints.insets = new Insets(inset, left, inset, inset);
        constraints.weightx = xWeight;
        constraints.weighty = yWeight;
        constraints.gridwidth = componentWidth;
        constraints.gridheight = componentHeight;
        constraints.anchor = alignment;
        constraints.fill = fill;
        return constraints;
    }

}
