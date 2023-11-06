package depaul.edu.Tests.GUITest;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import depaul.edu.Item.IAbstractItem;

class ItemDisplayPanel extends JPanel {
    private static final int GBC_INSET = 2;
    private IAbstractItem data;
    private JLabel itemNameLabel = new JLabel();
    private JLabel manufacturerLabel = new JLabel();
    private JLabel priceLabel = new JLabel();

    public ItemDisplayPanel() {
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        setLayout(new GridBagLayout());
        add(new JLabel("Item :"), createGridBagConstraints(0, 0));
        add(itemNameLabel, createGridBagConstraints(1, 0));

        add(new JLabel("Manufacturer :"), createGridBagConstraints(0, 1));
        add(manufacturerLabel, createGridBagConstraints(1, 1));

        add(new JLabel("Price :"), createGridBagConstraints(0, 2));
        add(priceLabel, createGridBagConstraints(1, 2));

        this.setBorder(border);
    }

    public ItemDisplayPanel(IAbstractItem item) {
        this();
        setData(item);
    }

    public final void setData(IAbstractItem item) {
        this.data = item;
        itemNameLabel.setText(item.getItemName());

        manufacturerLabel.setText(item.getManufacturer());

        priceLabel.setText(String.format("$%,.2f", item.getPrice()));

        this.setToolTipText(item.getItemName());
    }

    public IAbstractItem getData() {
        return data;
    }

    private GridBagConstraints createGridBagConstraints(int positionX, int positionY) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = positionX;
        constraints.gridy = positionY;
        constraints.insets = new Insets(GBC_INSET, GBC_INSET, GBC_INSET, GBC_INSET);
        constraints.insets.left = (positionX != 0) ? 3 * GBC_INSET : GBC_INSET;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        return constraints;
    }
}
