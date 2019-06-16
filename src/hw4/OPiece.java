package hw4;

import java.awt.Color;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * @author Riley Legleiter
 *
 * Contains all of the properties specific to the "Diagonal" Piece
 */
public class OPiece extends AbstractPiece {

	/**
	 * Constructor that sets the position and cells
	 */
	public OPiece(Position givenPosition) {
		super(givenPosition);
		Cell[] cells = new Cell[4];
		
		//if (icons.length != 2) throw new IllegalArgumentException();
		
		cells[0] = new Cell(new Icon(Color.YELLOW), new Position(0, 0));
		cells[1] = new Cell(new Icon(Color.YELLOW), new Position(0, 1));
		cells[2] = new Cell(new Icon(Color.YELLOW), new Position(1, 0));
		cells[3] = new Cell(new Icon(Color.YELLOW), new Position(1, 1));
		
		setCells(cells);
	}
}
