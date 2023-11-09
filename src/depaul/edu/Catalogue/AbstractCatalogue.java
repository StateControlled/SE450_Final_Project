package depaul.edu.Catalogue;

import java.io.File;
import java.util.ArrayList;

public abstract class AbstractCatalogue<T> {
    private File SOURCE_CATALOGUE_FILE;
    protected ArrayList<T> CATALOGUE;

    /**
     * Constructs a new Catalogue.
     **/
    public AbstractCatalogue(File catalogueSource, ArrayList<T> catalogueArray) {
        SOURCE_CATALOGUE_FILE = catalogueSource;
        CATALOGUE = catalogueArray;
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
     * Returns the Catalogue in the form of an ArrayList.
     * @throws NullPointerException If the Catalogue is null.
     **/
    public ArrayList<T> getCatalogueAsList() throws NullPointerException {
        if (CATALOGUE == null) {
            throw new NullPointerException("The Catalogue is NULL.");
        }
        return CATALOGUE;
    }

    /**
     * 
     **/
    protected void setCatalogueArray(ArrayList<T> catalogueArray) {
        CATALOGUE = catalogueArray;
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
     * @param file  The file to write.
     * @param list  The list of data to be written to the file.
     * @param append    If {@code true}, append the list to the existing file.
     *                  If {@code false}, the existing file will not be preserved.
     **/
    public abstract void writeToFile(File file, ArrayList<T> list, boolean append);


    /**
     * Reads a file and returns an ArrayList of objects.
     * 
     * @param file  The file to read.
     **/
    public abstract ArrayList<T> readFromFile(File file);
}
