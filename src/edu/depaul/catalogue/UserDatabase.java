package edu.depaul.catalogue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//import edu.depaul.customer.CustomerAdapter;
import edu.depaul.customer.User;

/**
 * The UserDatabase stores user information
 **/
public class UserDatabase extends AbstractCatalogue<User> {

	public UserDatabase(File catalogueSourceFile) {
		super(catalogueSourceFile);
	}
	
	@Override
	public User findInCatalogue(String key) {
		for (User u : this.getCatalogue()) {
			if (u.getName().equals(key)) {
				return u;
			}
		}
		return null;
	}

    @Override
    public ArrayList<User> readFromFile(File jsonFile) {
        ArrayList<User> result = null;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            Type collectionType = new TypeToken<ArrayList<User>>(){}.getType();
            result = gson.fromJson(reader, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
