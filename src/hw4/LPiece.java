package hw4;

import api.Icon;

import java.awt.Color;

import api.Cell;
import api.Position;

/**
 * @author Riley Legleiter
 *
 * Contains all of the properties specific to the "L" Piece
 */
public class LPiece extends AbstractPiece {

	int rotationPosition;
	
	/**
	 * Constructor that sets the position and cells
	 */
	public LPiece(Position givenPosition) {
		super(givenPosition);
		Cell[] cells = new Cell[4];
		rotationPosition = 0;
		
		//if (icons.length != 4) throw new IllegalArgumentException();
		
		cells[0] = new Cell(new Icon(Color.ORANGE), new Position(0, 1));
		cells[1] = new Cell(new Icon(Color.ORANGE), new Position(1, 1));
		cells[2] = new Cell(new Icon(Color.ORANGE), new Position(2, 1));
		cells[3] = new Cell(new Icon(Color.ORANGE), new Position(2, 2));
		
		setCells(cells);
	}
	
	/**
	 * Flips the L Piece across the vertical axis
	 */
	@Override
	public void transform() {
		Cell[] temp = getCells();
		
		switch(rotationPosition) {
		case 0:
			temp[0].setRow(1);
			temp[0].setCol(2);
			
			temp[2].setRow(1);
			temp[2].setCol(0);
			
			temp[3].setRow(2);
			temp[3].setCol(0);
			rotationPosition++;
			break;
			
		case 1:
			temp[0].setRow(2);
			temp[0].setCol(1);
			
			temp[2].setRow(0);
			temp[2].setCol(1);
			
			temp[3].setRow(0);
			temp[3].setCol(0);
			rotationPosition++;
			break;
			
		case 2:
			temp[0].setRow(1);
			temp[0].setCol(0);
			
			temp[2].setRow(1);
			temp[2].setCol(2);
			
			temp[3].setRow(0);
			temp[3].setCol(2);
			rotationPosition++;
			break;
			
		case 3:
			temp[0].setRow(0);
			temp[0].setCol(1);
			
			temp[2].setRow(2);
			temp[2].setCol(1);
			
			temp[3].setRow(2);
			temp[3].setCol(2);
			rotationPosition = 0;
			break;
		}
		
		setCells(temp);
	}
}
