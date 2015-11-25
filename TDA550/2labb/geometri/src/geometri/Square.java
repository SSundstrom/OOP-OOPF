package geometri;
import java.awt.*;

/**
 * Represents a drawable Square
 */
public class Square extends Rectangle{

    /**
     * Initialize a new square on defined position, size and color.
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     * @param side Size of ever side.
     * @param c Color of square.
     * @throws IllegalPositionException Exception if position is illegal.
     */
    public Square(int x, int y, int side, Color c) throws IllegalPositionException{
        super(x,y,side,side,c);
    }

    /**
     * Initialize a new square from an existing GeometricalForm.
     * @param f GeometricalForm to get coordinates from.
     * @param side Size of side.
     * @param c Color of square.
     */
    public Square(GeometricalForm f, int side, Color c) {
        super(f, side, side, c);
    }

    @Override
    public int hashCode() {
        return super.hashCode()*23;
    }
}
