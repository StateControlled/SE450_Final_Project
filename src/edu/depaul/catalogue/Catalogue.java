package edu.depaul.catalogue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import edu.depaul.item.AbstractItem;
import edu.depaul.item.ItemAdapter;

public class Catalogue extends AbstractCatalogue<AbstractItem> {

    public Catalogue(File catalogueSourceFile) {
        super(catalogueSourceFile);
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
    
}
