package geometri;
import java.awt.*;

/**
 * Represents a drawable Point
 */
public class Point extends AbstractGeometricalForm {



    /**
     * Initialize a new point.
     *
     * @param x The coordinate in x.
     * @param y The coordinate in y.
     * @param c The color of the Point.
     * @throws IllegalPositionException Exception if coordinates is illigal.
     */
    public Point(int x, int y, Color c) throws IllegalPositionException {
        super(x,y,0,0,c);
    }

    /**
     * Initialize a new point from an existing GeometricalForm.
     *
     * @param f The GeometricalForm to get coordinates from.
     * @param c The color of the Point.
     */
    public Point(GeometricalForm f, Color c) {
        super( f, 0, 0, c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fill(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), 2, 2);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int getArea() {
        return 0;
    }

    @Override
    public int getPerimeter() {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode()*17;
    }
}


