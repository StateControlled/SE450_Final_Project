package depaul.edu.Tests.GUIExample;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class DatumRenderer extends DatumPanel implements ListCellRenderer<Datum> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Datum> list, Datum value, int index, boolean isSelected, boolean cellHasFocus) {
        setDatum(value);
        return this;
    }

}
