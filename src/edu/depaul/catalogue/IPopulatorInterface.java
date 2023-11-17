package edu.depaul.catalogue;

import java.util.ArrayList;

public interface IPopulatorInterface<T> {
    /**
     * Generates a list of items and returns that list as an ArrayList.
     * This is intended for use in creating Populators to initialize this project's "databases".
     **/
    public ArrayList<T> generate();
}
