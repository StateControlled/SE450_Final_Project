package edu.depaul.test;
import java.util.ArrayList;

import edu.depaul.item.AbstractItem;
import edu.depaul.catalogue.Catalogue;
import java.io.File;

public class CatalogueTest {

    public static void main(String[] args) {
        File catalogue = new File("src\\edu\\depaul\\resources\\itemcatalogue.json");

        File testcat = new File("src\\edu\\depaul\\resources\\testcatalogue.json");
        System.out.println("CATALOGUE : " + catalogue.toPath());

        Catalogue C = new Catalogue(catalogue);
        System.out.println("******************************************");
        System.out.println("File write test.");
        ArrayList<AbstractItem> items = ItemTest.generateItems();
        C.writeToFile(catalogue, items);

        System.out.println("******************************************");
        System.out.println("File read test.");
        // TODO investigate why sometimes null
        ArrayList<AbstractItem> readIn = C.readFromFile(testcat);
        for (AbstractItem i : readIn) {
            System.out.println(i.toString() + "\n");
        }
    }
}
