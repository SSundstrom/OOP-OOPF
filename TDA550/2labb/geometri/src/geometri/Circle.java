package geometri;

import java.awt.*;

/**
 * Represents a drawable Circle
 */
public class Circle extends Oval {

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
    }

    /**
     * Initialize a new square from an existing GeometricalForm.
     *
     * @param f        GeometricalForm to get coordinates from.
     * @param diameter The diameter of the circle.
     * @param c        The color of the circle.
     */
    public Circle(GeometricalForm f, int diameter, Color c) {
        super(f, diameter, diameter, c);
    }

    @Override
    public int getPerimeter() {
//      The height is equal to the diameter of the circle.
        return (int)(getHeight()*Math.PI);
    }
}
