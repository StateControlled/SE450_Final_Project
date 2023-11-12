package edu.depaul.catalogue;

import java.io.File;
import java.util.ArrayList;

import edu.depaul.customer.AbstractCustomer;

public class UserDatabase extends AbstractCatalogue<AbstractCustomer> {

	public UserDatabase(File catalogueSourceFile) {
		super(catalogueSourceFile);
	}

	@Override
	public ArrayList<AbstractCustomer> readFromFile(File jsonFile) {
		// TODO Auto-generated method stub
		return null;
	}

}
