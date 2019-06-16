package hw4;

import api.Icon;
import java.awt.Color;
import api.Cell;
import api.Position;

/**
 * @author Riley Legleiter
 *
 * Contains all of the properties specific to the "I" Piece
 */
public class IPiece extends AbstractPiece {
	
	/**
	 * Constructor that sets the position and cells
	 */
	public IPiece(Position givenPosition) {
		super(givenPosition);
		Cell[] cells = new Cell[4];
		
		//if (icons.length != 4) throw new IllegalArgumentException();

		cells[0] = new Cell(new Icon(Color.CYAN), new Position(0, 1));
		cells[1] = new Cell(new Icon(Color.CYAN), new Position(1, 1));
		cells[2] = new Cell(new Icon(Color.CYAN), new Position(2, 1));
		cells[3] = new Cell(new Icon(Color.CYAN), new Position(3, 1));
		
		setCells(cells);
	}
	
	@Override
	public void transform() {
		Cell[] temp = getCells();
		
		for (int i = 0; i < temp.length; i++) {
			int tempCol = temp[i].getCol();
			
			temp[i].setCol(temp[i].getRow());
			temp[i].setRow(tempCol);
		}
		
		setCells(temp);
	}
}
