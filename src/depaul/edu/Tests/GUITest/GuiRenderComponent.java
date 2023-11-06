package depaul.edu.Tests.GUITest;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import depaul.edu.Item.IAbstractItem;

class GuiRenderComponent extends ItemDisplayPanel implements ListCellRenderer<IAbstractItem> {

    @Override
    public Component getListCellRendererComponent(JList<? extends IAbstractItem> list, IAbstractItem value, int index, boolean isSelected, boolean cellHasFocus) {
        setData(value);
        return this;
    }

}
