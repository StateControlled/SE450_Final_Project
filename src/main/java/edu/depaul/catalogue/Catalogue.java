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

import main.java.edu.depaul.item.AbstractItem;
import main.java.edu.depaul.item.ItemAdapter;
import main.resources.constants.StorageFiles;

public class Catalogue implements IAbstractCatalogue<AbstractItem> {
    private static File SOURCE_CATALOGUE_FILE;
    private static ArrayList<AbstractItem> list;
    private static Catalogue instance;

    private Catalogue() {
        SOURCE_CATALOGUE_FILE = StorageFiles.CATALOGUE_SOURCE;
        list = readFromFile(SOURCE_CATALOGUE_FILE);
    }

    public static Catalogue getInstance() {
        if (instance == null) {
            instance = new Catalogue();
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
    public ArrayList<AbstractItem> readFromFile(File jsonFile) {
        ArrayList<AbstractItem> result = null;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(AbstractItem.class, new ItemAdapter());
        Gson gson = builder.setPrettyPrinting().create();

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            Type collectionType = new TypeToken<ArrayList<AbstractItem>>(){}.getType();
            result = gson.fromJson(reader, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
	public AbstractItem findInCatalogue(String key) {
		for (AbstractItem item : getCatalogue()) {
			if (item.getItemName().equals(key)) {
				return item;
			}
		}
		return null;
	}

    @Override
    public File getSourceFile() {
        return SOURCE_CATALOGUE_FILE;
    }

    @Override
    public ArrayList<AbstractItem> getCatalogue() {
        return list;
    }

    @Override
    public boolean addEntry(AbstractItem item) {
        return list.add(item);
    }

    @Override
    public boolean removeEntry(AbstractItem item) {
        return list.remove(item);
    }

    @Override
    public void writeToFile(File jsonFile, ArrayList<AbstractItem> list) {
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
