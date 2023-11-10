package depaul.edu.Catalogue;

import java.io.File;
import java.util.ArrayList;

import depaul.edu.Item.IAbstractItem;

/**
 * The {@code CATALOGUE} is a list of products that are available for a user to view. <p>
 * 
 * The Catalogue class contains methods for accessing and modifying the {@code CATALOGUE}. <p>
 * 
 * Call {@code Catalogue.getInstance()} first.
 **/
public class TCatalogue extends AbstractCatalogueTest {
    private static final File CATALOGUE_FILE = new File("src\\depaul\\edu\\Catalogue\\products.csv");
    private static TCatalogue INSTANCE;

    private TCatalogue() {
        super(CATALOGUE_FILE);
    }

    public static TCatalogue getInstance() {
        if (CATALOGUE == null) {
            INSTANCE = new TCatalogue();
        }
        return INSTANCE;
    }

    public static void refreshCatalogue() {
        CATALOGUE = readFileToList(CATALOGUE_FILE);
    }

    /**
     * Searches for a match to a given key in the manufacturer's names of all items in the {@code CATALOGUE}.
     **/
    public static ArrayList<IAbstractItem> findManufacturer(String key) {
        ArrayList<IAbstractItem> results = new ArrayList<>();
        String lKey = key.toLowerCase();
        for (IAbstractItem i : CATALOGUE) {
            String name = i.getManufacturer().toLowerCase();
            if (name.contains(lKey)) {
                results.add(i);
            }
        }
        return results;
    }

    /**
     * Searches for a match to a given key in the item names of all items in the {@code CATALOGUE}.
     **/
    public static ArrayList<IAbstractItem> findName(String key) {
        ArrayList<IAbstractItem> results = new ArrayList<>();
        String lKey = key.toLowerCase();
        for (IAbstractItem i : CATALOGUE) {
            String name = i.getItemName().toLowerCase();
            if (name.contains(lKey)) {
                results.add(i);
            }
        }
        return results;
    }
}
