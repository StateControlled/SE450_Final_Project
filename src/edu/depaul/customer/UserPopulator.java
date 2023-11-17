package edu.depaul.customer;

import java.util.ArrayList;

import edu.depaul.catalogue.IPopulatorInterface;

public class UserPopulator implements IPopulatorInterface<User> {
	
	public ArrayList<User> generate() {
		ArrayList<User> list = new ArrayList<>();
		User c1 = new User(2000, "Joe", "password1");
		list.add(c1);
		
		User c2 = new User(2045, "Bob", "imcool");
		list.add(c2);
		
		User c3 = new User(2105, "Sam", "trumpet");
		list.add(c3);
		
		return list;
	}
}
