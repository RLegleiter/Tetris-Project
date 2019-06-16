package hw4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import api.AbstractGame;
import api.Generator;
import api.Icon;
import api.Position;

/**
 * @author Riley Legleiter
 *
 * The class that sets up the game to play with certain rules.
 * If the there are 3 Icons on the game screen that are adjacent and have the same color, then
 * they will disappear and drop the Icons above the respective distance.
 */
public class BlockAddiction extends AbstractGame {
	
	/**
	 * Standard constructor. Creates the game with an empty grid.
	 * @param givenHeight
	 * 	the height of the grid
	 * @param givenWidth
	 * 	the width of the grid
	 * @param generator
	 * 	the generator that determines what Pieces get dropped
	 */
	public BlockAddiction(int givenHeight, int givenWidth, Generator generator) {
		super(givenHeight, givenWidth, generator);
	}
	
	/**
	 * Searches through the grid of Icons to find where there are
	 * 3 or more adjacent Icons of the same color. If Icons are found, 
	 * then they are put into a list and are removed from the grid
	 */
	@Override
	public List<Position> determinePositionsToCollapse() {
		List<Position> positions = new ArrayList<>();
		for (int row = 0; row < getHeight(); ++row) {
			if (isRowFilled(row)) {
				// row forms a collapsible set, put all positions in the list
				for (int col = 0; col < getWidth(); ++col) {
					positions.add(new Position(row, col));
				}
			}
		}

		// the algorithm above already guarantees there are no duplicates in the
		// list, but we have to sort them
		Collections.sort(positions);
		return positions;
	}
	
	private boolean isRowFilled(int row) {
		for (int col = 0; col < getWidth(); ++col) {
			if (getIcon(row, col) == null) {
				return false;
			}
		}
		return true;
	}
}
