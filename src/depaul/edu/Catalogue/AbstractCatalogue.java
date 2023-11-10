package depaul.edu.Catalogue;

import java.io.File;
import java.util.ArrayList;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractCatalogue<T> {
    private File SOURCE_CATALOGUE_FILE;
    //protected ArrayList<T> CATALOGUE;

    /**
     * Constructs a new Catalogue.
     **/
    public AbstractCatalogue(File catalogueSource) {
        SOURCE_CATALOGUE_FILE = catalogueSource;
        //CATALOGUE = catalogueArray;
    }

    /**
     * Returns the file path of the source catalogue file.
     * @param absolute  if {@code true} will return the absolute path. If {@code false} will return a relative file path.
     **/
    public String getCatalogueFilePath(boolean absolute) {
        if (absolute) {
            return SOURCE_CATALOGUE_FILE.getAbsolutePath();
        }
        return SOURCE_CATALOGUE_FILE.getPath();
    }

    /**
     * Returns, as a {@code File} object, the source file for this Catalogue.
     **/
    public File getSourceFile() {
        return SOURCE_CATALOGUE_FILE;
    }

    /**
     * Writes a list of elements to a given file.
     * 
     * @param file  The file to write to.
     * @param list  The list of data to be written to the file.
     * @param append    If {@code true}, append the list to the existing file.
     *                  If {@code false}, the existing file will not be preserved.
     **/
    public void writeToFile(File file, ArrayList<T> list, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            for (T item : list) {
                String data = item.toString();
                writer.append(data);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
		    System.out.println("Failed to read or write file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Searches a file for a given key.
     * @param file  the file to search
     * @param key   the key to search the file for
     * @param column    if the file is a .csv or other separated file, this is the column in which to search.
     **/
    public static boolean findInFile(File file, String key, int column) {
        // TODO
        return false;
    }
}
