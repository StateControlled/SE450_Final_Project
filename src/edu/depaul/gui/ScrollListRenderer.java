package edu.depaul.gui;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import edu.depaul.item.AbstractItem;

public class ScrollListRenderer extends DisplayPanel implements ListCellRenderer<AbstractItem> {

    @Override
    public Component getListCellRendererComponent(JList<? extends AbstractItem> list, AbstractItem value, int index, boolean isSelected, boolean cellHasFocus) {
        setData(value);
        return this;
    }
    
}