package depaul.edu.Tests.GUIExample;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

class DataPanel extends JPanel implements Scrollable {
    private int visibleRowCount;

    public DataPanel(int visibleRowCount) {
        this.visibleRowCount = visibleRowCount;
        setLayout(new GridLayout(0, 1));
    }

    public void addDatum(Datum datum) {
        add(new DatumPanel(datum));
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            int width = getPreferredSize().width;
            int height = visibleRowCount * comp.getPreferredSize().height;

            Dimension dimension = new Dimension(width, height);
            System.out.println(dimension);
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
            JComponent comp = (JComponent) getComponents()[0];
            Dimension d = comp.getPreferredSize();
            if (orientation == SwingConstants.VERTICAL) {
                return visibleRowCount * d.height;
            } else {
                return d.width;
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
