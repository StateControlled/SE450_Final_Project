package edu.depaul.catalogue;

import java.io.File;
import java.util.ArrayList;

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
     * Retrieves the catalogue.
     **/
    public ArrayList<T> getCatalogue();
    
    /**
     * Adds an entry to the catalogue.
     **/
    public boolean addEntry(T item);
    
    /**
     * Finds a single example of a given key in the catalogue.
     **/
    public T findInCatalogue(String key);
    
    /**
     * Removes an item from the catalogue.
     **/
    public boolean removeEntry(T item);

    /**
     * Reads a list of objects from a .json file.
     **/
    public ArrayList<T> readFromFile(File jsonFile);

    /**
     * Writes a list objects to a .json file.
     **/
    public void writeToFile(File jsonFile, ArrayList<T> list);
}
