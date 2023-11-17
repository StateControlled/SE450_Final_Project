package main.java.edu.depaul.catalogue;

import java.io.File;
import java.util.ArrayList;

/**
 * A catalogue implementing the IAbstractCatalogue interface should be designed as a singleton pattern for
 * best results.
 **/
public interface IAbstractCatalogue<T> {
    /**
     * Returns the number of entries in the catalogue.
     **/
    public int size();
    /**
     * Retreives the source file of the catalogue.
     **/
    public File getSourceFile();

    /**
     * Retrieves the catalogue as an ArrayList.
     **/
    public ArrayList<T> getCatalogue();
    
    /**
     * Adds a single entry to the catalogue.
     * @param item  the entry to be added
     **/
    public boolean addEntry(T item);
    
    /**
     * Finds a single example of a given key in the catalogue.
     * @param key   a short string describing the item to be found
     **/
    public T findInCatalogue(String key);
    
    /**
     * Removes an item from the catalogue. If multiple instances exist, will remove the first instance only.
     * @param item  the item to be removed
     **/
    public boolean removeEntry(T item);

    /**
     * Reads a list of objects from a .json file. These objects then populate the catalogue.
     * @param jsonFile  the source file to read
     **/
    public ArrayList<T> readFromFile(File jsonFile);

    /**
     * Writes a list of objects to a .json file. Intended for use saving the catalogue to file.
     * @param jsonFile  the file which will be written
     * @param list  the objects to be written to the file
     **/
    public void writeToFile(File jsonFile, ArrayList<T> list);
}
