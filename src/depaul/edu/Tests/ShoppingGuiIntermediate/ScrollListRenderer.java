package depaul.edu.Tests.ShoppingGuiIntermediate;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import depaul.edu.Item.IAbstractItem;

public class ScrollListRenderer extends DisplayPanel implements ListCellRenderer<IAbstractItem> {

    @Override
    public Component getListCellRendererComponent(JList<? extends IAbstractItem> list, IAbstractItem value, int index, boolean isSelected, boolean cellHasFocus) {
        setData(value);
        return this;
    }
    
}
