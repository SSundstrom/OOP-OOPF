package geometri;
import java.awt.*;

/**
 * Represents a drawable Rectangle
 */
public class Rectangle extends AbstractGeometricalForm {

    /**
     * Initilaze an new Rectangle.
     *
     * @param x      Coordinate in x.
     * @param y      Coordinate in y.
     * @param width  The width of the Rectangle.
     * @param height The height of the Rectangle.
     * @param c      The color of the Rectangle.
     * @throws IllegalPositionException Exception is coordinates is illegal.
     */
    public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
      super(x,y,width,height,c);
    }

    /**
     * Initialize a new Rectangle from existing GeometricalFrom.
     *
     * @param f      GeometricalForm to get coordinates from.
     * @param width  The width of the Rectangle.
     * @param height The height of the Rectangle.
     * @param c      The color of the Rectangle.
     */
    public Rectangle(GeometricalForm f, int width, int height, Color c) {
        super(f.getX(),f.getY(),width,height,c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fill(Graphics g) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getArea() {
        return 0;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int getPerimeter() {
        return 0;
    }
}