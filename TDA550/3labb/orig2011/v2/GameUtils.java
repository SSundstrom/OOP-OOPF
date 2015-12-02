package orig2011.v2;

import orig2011.v0.GameTile;
import orig2011.v0.Position;

import java.awt.*;

public class GameUtils {

    /**
     * Set the tile on a specified position in the gameboard.
     * @param gameboardState The gameboard matrix
     * @param pos
     *            The position in the gameboard matrix.
     * @param tile
     *            The type of tile to paint in specified position
     */
    public static void setGameboardState(final GameTile[][] gameboardState, Position pos, final GameTile tile) {
        setGameboardState(gameboardState, pos.getX(), pos.getY(), tile);
    }

    /**
     * Set the tile on a specified position in the gameboard.
     *
     *  @param gameboardState The gameboard matrix
     * @param x
     *            Coordinate in the gameboard matrix.
     * @param y
     *            Coordinate in the gameboard matrix.
     * @param tile
     *            The type of tile to paint in specified position
     */
    public static void setGameboardState(final GameTile[][] gameboardState, final int x, final int y,
                                     final GameTile tile) {
       gameboardState[x][y] = tile;
    }

}
