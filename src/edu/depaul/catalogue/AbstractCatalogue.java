package edu.depaul.catalogue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public abstract class AbstractCatalogue<T> {
    private File SOURCE_CATALOGUE_FILE;
    private ArrayList<T> list;

    public AbstractCatalogue(File catalogueSourceFile) {
        this.SOURCE_CATALOGUE_FILE = catalogueSourceFile;
        this.list = readFromFile(SOURCE_CATALOGUE_FILE);
    }

    public File getSourceFile() {
        return SOURCE_CATALOGUE_FILE;
    }

    public ArrayList<T> getCatalogue() {
        return list;
    }

    /**
     * Reads objects from a .json file.
     **/
    public ArrayList<T> readFromFile(File jsonFile) {
        ArrayList<T> result = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            Type collectionType = new TypeToken<ArrayList<T>>(){}.getType();
            result = gson.fromJson(reader, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Writes objects to a .json file.
     **/
    public void writeToFile(File jsonFile, ArrayList<T> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(list, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
