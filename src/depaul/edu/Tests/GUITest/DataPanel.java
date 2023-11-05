package depaul.edu.Tests.GUITest;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

class DataPanel extends JPanel implements Scrollable {
    private int visibleRowCount = 1;

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
            Dimension d = new Dimension(width, height);
            System.out.println(d);
            return d;
        } else {
            return new Dimension(0, 0);
        }
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            Dimension d = comp.getPreferredSize();
            if (orientation == SwingConstants.VERTICAL) {
                return d.height;
            } else {
                return d.width;
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
