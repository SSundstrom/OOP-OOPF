package orig2011.v7;


import java.awt.*;


/**
 * Common superclass for all game model classes.
 * 
 * Constructors of subclasses should initiate matrix elements and additional,
 * game-dependent fields.
 */
public interface GameModel extends IObservable {

	/**
	 * Returns the GameTile in logical position (x,y) of the gameboard.
	 *
	 * @param pos
	 *            The position in the gameboard matrix.
	 */
	 GameTile getGameboardState(final Position pos);

	/**
	 * Returns the GameTile in logical position (x,y) of the gameboard.
	 *
	 * @param x
	 *            Coordinate in the gameboard matrix.
	 * @param y
	 *            Coordinate in the gameboard matrix.
	 */
	 GameTile getGameboardState(final int x, final int y);

	/**
	 * Returns the size of the gameboard.
	 */
	 Dimension getGameboardSize();

	/**
	 * This method is called repeatedly so that the game can update it's state.
	 *
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	void gameUpdate(int lastKey) throws GameOverException;

	int getUpdateSpeed();

}
