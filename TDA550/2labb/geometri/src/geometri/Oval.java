package geometri;
import java.awt.*;

/**
 * Represents a drawable Point
 */
public class Oval extends AbstractGeometricalForm{

    /**
     * Initialize a new Oval.
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     * @param width The width of the Oval.
     * @param height The height of the Oval.
     * @param c The color of the Oval.
     * @throws IllegalPositionException Exception if coordinates is illegal.
     */
    public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException{
    super(x, y, width, height, c);
    }

    /**
     * Initialize a new Oval from an existing GeometricalForm.
     * @param f The GeometricalForm to get coordinates from.
     * @param width The width of the Oval.
     * @param height The height of the Oval.
     * @param c The color of Oval.
     */
    public Oval(GeometricalForm f, int width, int height, Color c){
        super(f, width, height, c);
    }

    @Override
    public void fill(Graphics g) {

    }

    @Override
    public int getArea() {
        return 0;
    }

    @Override
    public int getPerimeter() {
        return 0;
    }
}
