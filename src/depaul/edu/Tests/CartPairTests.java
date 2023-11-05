package depaul.edu.Tests;

import depaul.edu.Item.IAbstractItem;
import depaul.edu.Item.ItemFactory;
import depaul.edu.Item.ItemType;
import depaul.edu.ShoppingCart.CartPair;

public class CartPairTests {
    	IAbstractItem item1 = ItemFactory.createProduct(ItemType.VIOLIN, "Amazon", "Bad Violin", 99.95);
        IAbstractItem item2 = ItemFactory.createProduct(ItemType.VIOLA, "Amazon", "Bad Viola", 109.99);
        IAbstractItem item3 = ItemFactory.createProduct(ItemType.CELLO, "Amazon", "Bad Cello", 114.95);
        IAbstractItem item4 = ItemFactory.createProduct(ItemType.BASS, "Amazon", "Bad Bass", 149.99);
        IAbstractItem item5 = ItemFactory.createProduct(ItemType.PIANO, "Amazon", "Bad Piano", 119.95);

        CartPair pair1 = new CartPair(item1, 1);
        CartPair pair2 = new CartPair(item2, 2);
        CartPair pair3 = new CartPair(item3, -1);

}
