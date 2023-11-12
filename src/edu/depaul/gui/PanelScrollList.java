package edu.depaul.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

import edu.depaul.item.AbstractItem;

@SuppressWarnings("serial")
public class PanelScrollList extends JPanel implements Scrollable {
    private int visibleRowCount;

    public PanelScrollList(int visibleRowCount) {
        this.visibleRowCount = visibleRowCount;
        setLayout(new GridLayout(0, 1));
    }

    public void addItemToScrollList(AbstractItem item) {
        add(new DisplayPanel(item));
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        if (getComponentCount() > 0) {
            JComponent component = (JComponent) getComponents()[0];
            int width = 2 * getPreferredSize().width;
            int height = visibleRowCount * component.getPreferredSize().height;

            Dimension dimension = new Dimension(width, height);

            return dimension;
        } else {
            return new Dimension(0, 0);
        }
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        if (getComponentCount() > 0) {
            JComponent component = (JComponent) getComponents()[0];
            Dimension dimension = component.getPreferredSize();

            if (orientation == SwingConstants.VERTICAL) {
                return dimension.height;
            } else {
                return dimension.width;
            }
        }
        return 0;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        if (getComponentCount() > 0) {
            JComponent component = (JComponent) getComponents()[0];
            Dimension dimension = component.getPreferredSize();

            if (orientation == SwingConstants.VERTICAL) {
                return visibleRowCount * dimension.height;
            } else {
                return dimension.width;
            }
        }
        return 0;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
