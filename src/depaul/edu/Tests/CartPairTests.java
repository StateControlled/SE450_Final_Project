package depaul.edu.Tests;

import depaul.edu.Item.IAbstractItem;
import depaul.edu.Item.ItemFactory;
import depaul.edu.Item.ItemType;

public class CartPairTests {
    	IAbstractItem item1 = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Bad Violin", 119.95);


        IAbstractItem item2 = ItemFactory.createProduct(ItemType.VIOLA, "Amazon", "Bad Violin", 119.95);


        IAbstractItem item3 = ItemFactory.createProduct(ItemType.CELLO, "Amazon", "Bad Violin", 119.95);


        IAbstractItem item4 = ItemFactory.createProduct(ItemType.BASS, "Amazon", "Bad Violin", 119.95);

        
        IAbstractItem item5 = ItemFactory.createProduct(ItemType.PIANO, "Amazon", "Bad Violin", 119.95);

}
