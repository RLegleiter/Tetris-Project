package hw4;

import api.Cell;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * @author Riley Legleiter
 *
 * Abstract class connecting the rest of the Piece classes.
 * Contains all of the methods that all of the Pieces have in common
 */
public abstract class AbstractPiece implements Piece {

	/**
	 * Keeps track of the position of the Piece on the game screen
	 */
	private Position position;
	
	/**
	 * Keeps track of an Icons color and position within the
	 * Pieces bounding box.
	 */
	private Cell[] cells;
	
	/**
	 * Default constructor for the Pieces
	 * @param p
	 * 	position for the piece to be at
	 * @param icons
	 * 	the icons to appear in a piece
	 */
	protected AbstractPiece(Position p) {
		position = p;
	}
	
	/**
	 * Empty method. Is overridden by all of the Pieces.
	 * Determines how the piece transforms when the "up" key is pressed
	 */
	public void transform() {}
	
	public void cycle() {}

	/**
	 * Returns the position of the Piece
	 * @return
	 * 	position of the shape
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Sets the cells to a Piece
	 * @param givenCells
	 * 	the array of cells to set as the Pieces cells
	 */
	public void setCells(Cell[] givenCells) {
		// deep copy the given array
		cells = new Cell[givenCells.length];
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new Cell(givenCells[i]);
		}
	}

	/**
	 * Gets the cells of a Piece
	 * @return
	 * 	copy of the cells in this piece
	 */
	public Cell[] getCells() {
		// deep copy this object's cell array
		Cell[] copy = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			copy[i] = new Cell(cells[i]);
		}
		return copy;
	}
	
	/**
	 * Gets the position of the cells in a Piece in relation to game grid
	 * @return
	 * 	copy of the cells in this piece, with absolute positions
	 */
	public Cell[] getCellsAbsolute() {
		Cell[] ret = new Cell[cells.length];

		for (int i = 0; i < cells.length; i++) {
			int row = cells[i].getRow() + position.row();
			int col = cells[i].getCol() + position.col();
			Icon b = cells[i].getIcon();
			ret[i] = new Cell(b, new Position(row, col));
		}
		return ret;
	}

	/**
	 * Shifts the position of the Piece down one row
	 */
	public void shiftDown() {
		position = new Position(position.row() + 1, position.col());
	}

	/**
	 * Shifts the position of the Piece to the left
	 */
	public void shiftLeft() {
		position = new Position(position.row(), position.col() - 1);
	}

	/**
	 * Shifts the position of the Piece to the right
	 */
	public void shiftRight() {
		position = new Position(position.row(), position.col() + 1);
	}
	
	/**
	 * Returns a deep copy of this object having the correct runtime type.
	 * @return
	 * 	a deep copy of the object
	 */
	public Piece clone() {
		
		try {
			AbstractPiece s;
			
			// Checks to see what kind of piece the child piece is.
			// Used to determine which piece to clone
			
			if (TPiece.class.equals(this.getClass())) {
				s = (TPiece) super.clone();
				
			} else if (LPiece.class.equals(this.getClass())) {
				s = (LPiece) super.clone();
				
			} else if (OPiece.class.equals(this.getClass())) {
				s = (OPiece) super.clone();
				
			} else if (IPiece.class.equals(this.getClass())) {
				s = (IPiece) super.clone();
					
			} else if (SPiece.class.equals(this.getClass())) {
				s = (SPiece) super.clone();
				
			} else if (ZPiece.class.equals(this.getClass())) {
				s = (ZPiece) super.clone();
				
			} else {
				s = (JPiece) super.clone();
			}
			
			s.cells = new Cell[cells.length];
			for (int i = 0; i < cells.length; ++i) {
				s.cells[i] = new Cell(cells[i]);
			}
			return s;
			
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}