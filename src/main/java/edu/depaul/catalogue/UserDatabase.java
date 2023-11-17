package main.java.edu.depaul.catalogue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import main.java.edu.depaul.customer.User;
import main.resources.constants.StorageFiles;

/**
 * The UserDatabase stores user information
 **/
public class UserDatabase implements IAbstractCatalogue<User> {
    private static File SOURCE_CATALOGUE_FILE;
    private static ArrayList<User> list;
    private static UserDatabase instance;

	private UserDatabase() {
        SOURCE_CATALOGUE_FILE = StorageFiles.USER_DATABASE;
        list = readFromFile(SOURCE_CATALOGUE_FILE);
	}

    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    /**
     * This method will write all changes to the database to file.
     * It should be called before exiting the program.
     **/
    public static void close() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(SOURCE_CATALOGUE_FILE)) {
            gson.toJson(list, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public File getSourceFile() {
        return SOURCE_CATALOGUE_FILE;
    }

    @Override
    public ArrayList<User> getCatalogue() {
        return list;
    }

    @Override
    public boolean addEntry(User item) {
        return list.add(item);
    }

    @Override
    public boolean removeEntry(User item) {
        return list.remove(item);
    }

    @Override
    public void writeToFile(File jsonFile, ArrayList<User> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(list, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return list.size();
    }

}
