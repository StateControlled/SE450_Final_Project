package main.java.edu.depaul.order;

import java.util.ArrayList;
import java.util.HashMap;

import main.java.edu.depaul.catalogue.IPopulatorInterface;
import main.java.edu.depaul.customer.User;
import main.java.edu.depaul.item.AbstractItem;
import main.java.edu.depaul.item.ItemPopulator;

public class OrderPopulator implements IPopulatorInterface<Order> {
	
	public ArrayList<Order> generate() {
		ArrayList<Order> list = new ArrayList<>();
		ArrayList<AbstractItem> items = new ItemPopulator().generate();
		
		HashMap<AbstractItem, Integer> cart1 = new HashMap<>();
		cart1.put(items.get(0), 2);
		cart1.put(items.get(1), 1);
		
		list.add(new Order(new User(90155, "Susan", "frenchhorn"), cart1));
		
		HashMap<AbstractItem, Integer> cart2 = new HashMap<>();
		cart2.put(items.get(12), 2);
		cart2.put(items.get(13), 4);
		cart2.put(items.get(14), 7);
		
		list.add(new Order(new User(92007, "Joanie", "architecture"), cart2));
		
		return list;
	}
}
