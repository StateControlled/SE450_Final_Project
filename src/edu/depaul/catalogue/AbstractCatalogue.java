package edu.depaul.catalogue;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
     * Reads objects from a .json file. This method must be individually defined in a descendent class.
     **/
    public abstract ArrayList<T> readFromFile(File jsonFile);

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
