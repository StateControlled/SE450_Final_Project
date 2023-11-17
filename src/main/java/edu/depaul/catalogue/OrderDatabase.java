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

import main.java.edu.depaul.order.Order;
import main.resources.constants.StorageFiles;

public class OrderDatabase implements IAbstractCatalogue<Order> {
    private static File SOURCE_CATALOGUE_FILE;
    private static ArrayList<Order> list;
    private static OrderDatabase instance;

    private OrderDatabase() {
        SOURCE_CATALOGUE_FILE = StorageFiles.ORDER_DATABASE;
        list = readFromFile(SOURCE_CATALOGUE_FILE);
    }

    public static OrderDatabase getInstance() {
        if (instance == null) {
            instance = new OrderDatabase();
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
	public ArrayList<Order> readFromFile(File jsonFile) {
        ArrayList<Order> result = null;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            Type collectionType = new TypeToken<ArrayList<Order>>(){}.getType();
            result = gson.fromJson(reader, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	@Override
	public Order findInCatalogue(String key) {
		for (Order order : this.getCatalogue()) {
			if (order.getCustomerName().equals(key)) {
				return order;
			}
		}
		return null;
	}

	@Override
	public File getSourceFile() {
		return SOURCE_CATALOGUE_FILE;
	}

	@Override
	public ArrayList<Order> getCatalogue() {
		return list;
	}

	@Override
	public boolean addEntry(Order item) {
		return list.add(item);
	}

	@Override
	public boolean removeEntry(Order item) {
		return list.remove(item);
	}

	@Override
	public void writeToFile(File jsonFile, ArrayList<Order> list) {
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
