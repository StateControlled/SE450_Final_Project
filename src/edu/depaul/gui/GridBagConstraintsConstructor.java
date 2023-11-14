package edu.depaul.gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public interface GridBagConstraintsConstructor {
	/**
	 * Defines positioning for components in a JFrame or related object. This method is used to determine object
	 * positioning within a {@code GridBag} layout
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param xWeight
	 * @param yWeight
	 * @param componentWidth
	 * @param componentHeight
	 * @param alignment	sets GridBagConstrains.anchor
	 * @param inset sets GridBagConstraints.insets. A general formula has already been defined.
	 * @param fill
	 * @return
	 * 
	 * @see java.awt.GridBagConstraints#anchor
	 * @see java.awt.GridBagConstraints#insets
	 **/
    public static GridBagConstraints setGridBagConstraints(int xCoordinate, int yCoordinate, double xWeight, double yWeight, 
    		int componentWidth, int componentHeight, int alignment, int inset, int fill) {
        GridBagConstraints constraints = new GridBagConstraints();
        int left = (xCoordinate != 0) ? 3 * inset : inset;
        constraints.gridx = xCoordinate;
        constraints.gridy = yCoordinate;
        constraints.insets = new Insets(inset, left, inset, inset);
        constraints.weightx = xWeight;
        constraints.weighty = yWeight;
        constraints.gridwidth = componentWidth;
        constraints.gridheight = componentHeight;
        constraints.anchor = alignment;
        constraints.fill = fill;
        return constraints;
    }
}
