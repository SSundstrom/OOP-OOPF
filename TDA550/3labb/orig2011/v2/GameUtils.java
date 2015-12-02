package orig2011.v2;

import orig2011.v0.GameTile;
import orig2011.v0.Position;

import java.awt.*;

public class GameUtils {

    /**
     * Set the tile on a specified position in the gameboard.
     *
     * @param pos
     *            The position in the gameboard matrix.
     * @param tile
     *            The type of tile to paint in specified position
     */
    public void setGameboardState(final Position pos, final GameTile tile) {
        setGameboardState(pos.getX(), pos.getY(), tile);
    }

    /**
     * Set the tile on a specified position in the gameboard.
     *
     * @param x
     *            Coordinate in the gameboard matrix.
     * @param y
     *            Coordinate in the gameboard matrix.
     * @param tile
     *            The type of tile to paint in specified position
     */
    public void setGameboardState(ReversiModel.Turn t, Position p, ReversiModel.PieceColor[][] board) {
         board[p.getX()][p.getY()] = t;
    }

    /**
     * Returns the GameTile in logical position (x,y) of the gameboard.
     *
     * @param pos
     *            The position in the gameboard matrix.
     */
    public GameTile getGameboardState(final Position pos) {
        return getGameboardState(pos.getX(), pos.getY());
    }

    /**
     * Returns the GameTile in logical position (x,y) of the gameboard.
     *
     * @param x
     *            Coordinate in the gameboard matrix.
     * @param y
     *            Coordinate in the gameboard matrix.
     */
    public GameTile getGameboardState(GameModel gm, final int x, final int y) {
        return ;
    }

    /**
     * Returns the size of the gameboard.
     */
    public Dimension getGameboardSize() {
        return this.gameboardSize;
    }

}
