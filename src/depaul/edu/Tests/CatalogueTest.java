package depaul.edu.Tests;

import depaul.edu.Catalogue.Catalogue;
import depaul.edu.Item.IAbstractItem;
import java.util.ArrayList;

//D:\Programming\SE450 Object Oriented Software Development\Final Project\SE450_Final_Project\src\depaul\edu\Catalogue

public class CatalogueTest {

    public static void main(String[] args) {
		Catalogue.getInstance();
		ArrayList<IAbstractItem> list = Catalogue.getCatalogueAsList();

		for (IAbstractItem i : list) {
			System.out.println(i.toString());
			System.out.println();
		}

		ArrayList<IAbstractItem> test1 = Catalogue.findName("Viol");
		test1.forEach((item) -> System.out.println(item.toString()));
		
	}
}
