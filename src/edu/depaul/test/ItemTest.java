package edu.depaul.test;

import java.util.ArrayList;

import edu.depaul.factory.SuperFactory;
import edu.depaul.item.AbstractItem;
import edu.depaul.item.Category;

public class ItemTest {
    public static void main(String[] args) {
        ArrayList<AbstractItem> list = generateItems();
        for (AbstractItem i : list) {
            System.out.println(i.toString());
            System.out.println();
            System.out.println(i.view());
            System.out.println();
        }
    }

    public static ArrayList<AbstractItem> generateItems() {
        ArrayList<AbstractItem> result = new ArrayList<>();
        AbstractItem item1 = SuperFactory.getProduct(Category.INSTRUMENT, "violin", "Trash Violin", "Amazon", 99.95);
        result.add(item1);

        AbstractItem item2 = SuperFactory.getProduct(Category.INSTRUMENT, "viola", "Professional Viola", "Benjamin Ruth", 19500.0);
        result.add(item2);
        return result;

    }
}
