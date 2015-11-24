package geometri;

import java.awt.*;
import java.util.Objects;

/**
 * Represents a drawable Circle
 */
public class Circle extends AbstractGeometricalForm {

    private int diameter;

    /**
     * Initialize a new Circle on defined position, diameter and color.
     *
     * @param x        Coordinate in x.
     * @param y        Coordinate in y.
     * @param diameter The diameter of the circle.
     * @param c        The color of the square.
     * @throws IllegalPositionException Exception if coordinates is illegal.
     */
    public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
        super(x, y, diameter, diameter, c);
        this.diameter = diameter;
    }

    /**
     * Initialize a new square from an existing GeometricalForm.
     *
     * @param f        GeometricalForm to get coordinates from.
     * @param diameter The diameter of the circle.
     * @param c        The color of the circle.
     */
    public Circle(GeometricalForm f, int diameter, Color c) {
        super(f.getX(), f.getY(), diameter, diameter, c);
        this.diameter = diameter;
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
