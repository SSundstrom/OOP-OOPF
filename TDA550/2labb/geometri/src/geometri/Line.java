package geometri;
import java.awt.*;

/**
 * Represents a drawable Line
 */
public class Line extends AbstractGeometricalForm {

    private boolean isIncreasing;
    /**
     * Initialize a new Line.
     *
     * @param x1 Start coordinate in x.
     * @param y1 Start coordinate in y.
     * @param x2 End coordinate in x.
     * @param y2 End coordinate in y.
     * @param c  Color of the Line.
     * @throws IllegalPositionException Exception if coordinates is invalid.
     */
    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
        super(x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2), c);
        this.isIncreasing = (y1 - y2) * (x1 - x2) > 0;
    }

    /**
     * Initialize a new Line from two excising GeometricalForms.
     *
     * @param f1 GeometricalForm to get start coordinates.
     * @param f2 GeometricalForm to get end coordinates.
     * @param c  Color of the Line.
     */
    public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
        super(f1.getX(), f1.getY(), Math.abs(f1.getX() - f2.getX()), Math.abs(f1.getY() - f2.getY()), c);
        this.isIncreasing = (f1.getY() - f2.getY()) * (f1.getX() - f2.getX()) > 0;
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
        return this.getWidth();
    }
}