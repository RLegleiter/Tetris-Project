
package hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * Generator for Piece objects in BlockAddiction. Icons are always selected
 * uniformly at random, and the Piece types are generated with the following
 * probabilities:
 * <ul>
 * <li>LPiece - 10%
 * <li>DiagonalPiece - 25%
 * <li>CornerPiece - 15%
 * <li>SnakePiece - 10%
 * <li>IPiece - 40%
 * </ul>
 * The initial position of each piece is based on its vertical size as well as
 * the width of the grid (given as an argument to getNext). The initial column
 * is always width/2 - 1. The initial row is: *
 * <ul>
 * <li>LPiece - row = -2
 * <li>DiagonalPiece - row = -1
 * <li>CornerPiece - row = -1
 * <li>SnakePiece - row = -1
 * <li>IPiece - row = -2
 * </ul>
 * 
 */
public class BasicGenerator implements Generator {
	private Random rand;

	/**
	 * Constructs a BasicGenerator that will use the given Random object as its
	 * source of randomness.
	 * 
	 * @param givenRandom instance of Random to use
	 */
	public BasicGenerator(Random givenRandom) {
		rand = givenRandom;
	}
	
	private ArrayList<Piece> pieces;
	
	/**
	 * Determines which Piece should be generated next. 
	 * Each Piece has its own probability of being generated
	 */
	@Override
	public Piece getNext(int width) {
		if (pieces == null || pieces.size() == 0) {
			pieces = loadPieces(width);
		}
		
		int r = rand.nextInt(pieces.size());
		Piece sendPiece = pieces.get(r);
		pieces.remove(r);
		return sendPiece;
	}
	
	private ArrayList<Piece> loadPieces(int width) {
		int col = width / 2 - 1;
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(new IPiece(new Position(-2, col)));
		pieces.add(new IPiece(new Position(-2, col)));
		pieces.add(new JPiece(new Position(-1, col)));
		pieces.add(new JPiece(new Position(-1, col)));
		pieces.add(new LPiece(new Position(-2, col)));
		pieces.add(new LPiece(new Position(-2, col)));
		pieces.add(new OPiece(new Position(-1, col)));
		pieces.add(new OPiece(new Position(-1, col)));
		pieces.add(new SPiece(new Position(-1, col)));
		pieces.add(new SPiece(new Position(-1, col)));
		pieces.add(new TPiece(new Position(-1, col)));
		pieces.add(new TPiece(new Position(-1, col)));
		pieces.add(new ZPiece(new Position(-1, col)));
		pieces.add(new ZPiece(new Position(-1, col)));
		
		return pieces;
	}
	
	/**
	 * Generates a random colored Icon
	 */
	@Override
	public Icon randomIcon() {
		return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);
	}

}
