package edu.depaul.catalogue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import edu.depaul.order.Order;

public class OrderDatabase extends AbstractCatalogue<Order> {

	public OrderDatabase(File catalogueSourceFile) {
		super(catalogueSourceFile);
	}

	@Override
	public ArrayList<Order> readFromFile(File jsonFile) {
        ArrayList<Order> result = null;
        GsonBuilder builder = new GsonBuilder();
        //builder.registerTypeAdapter(Order.class, new OrderAdapter());
        Gson gson = builder.setPrettyPrinting().create();

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            Type collectionType = new TypeToken<ArrayList<Order>>(){}.getType();
            result = gson.fromJson(reader, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
