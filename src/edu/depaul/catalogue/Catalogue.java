package edu.depaul.catalogue;

import java.io.File;

import edu.depaul.item.AbstractItem;

public class Catalogue extends AbstractCatalogue<AbstractItem> {

    public Catalogue(File catalogueSourceFile) {
        super(catalogueSourceFile);
    }
    
}
