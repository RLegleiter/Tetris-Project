package hw4;

import api.Icon;

import java.awt.Color;

import api.Cell;
import api.Position;

/**
 * @author Riley Legleiter
 *
 * Contains all of the properties specific to the "Snake" Piece
 */
public class TPiece extends AbstractPiece {
	/**
	 * Keeps track of the state of the Piece during transformation
	 */
	private int rotationPosition;
	
	private Cell[] stdPos;

	/**
	 * Constructor that sets the position and cells
	 */
	public TPiece(Position givenPosition) {
		super(givenPosition);
		Cell[] temp = new Cell[4];
		stdPos = new Cell[4];
		rotationPosition = 0;
		
		//if (icons.length != 4) throw new IllegalArgumentException();
		
		temp[0] = new Cell(new Icon(Color.MAGENTA), new Position(0, 1));
		temp[1] = new Cell(new Icon(Color.MAGENTA), new Position(1, 0));
		temp[2] = new Cell(new Icon(Color.MAGENTA), new Position(1, 1));
		temp[3] = new Cell(new Icon(Color.MAGENTA), new Position(1, 2));
		
		stdPos = temp;
		
		setCells(temp);
	}
	
	@Override
	public void transform() {
		Cell[] temp = getCells();
		
		switch(rotationPosition) {
		case 0:
			temp[3].setPosition(new Position(2, 1));
			rotationPosition++;
			break;
			
		case 1:
			temp[0].setPosition(new Position(1, 2));
			rotationPosition++;
			break;
			
		case 2:
			temp[1].setPosition(new Position(0, 1));
			rotationPosition++;
			break;
			
		case 3:
			temp = stdPos;
			rotationPosition = 0;
			break;
		}
		
		setCells(temp);
	}
}
