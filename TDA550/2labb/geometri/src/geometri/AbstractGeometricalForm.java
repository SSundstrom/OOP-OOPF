package geometri;

import java.awt.*;

/**
 * Abstract class for geometrical forms.
 */

public abstract class AbstractGeometricalForm implements GeometricalForm {

    private int x;
    private int y;
    private Color color;
    private int height;
    private int width;

    public AbstractGeometricalForm( int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }

    /**
     * {@inheritDoc}
     */
    public int getX() {
        return x;
    }
    /**
     * {@inheritDoc}
     */
    public int getY() {
        return y;
    }
    /**
     * {@inheritDoc}
     */
    public Color getColor() {
        return color;
    }

    /**
     * {@inheritDoc}
     */
    public void move(int dx, int dy) throws IllegalPositionException {

    }

    /**
     * {@inheritDoc}
     */
    public int getHeight() {
        return height;
    }

    /**
     * {@inheritDoc}
     */
    public int getWidth() {
        return width;
    }

    /**
     * {@inheritDoc}
     */
    public void place(int x, int y) throws IllegalPositionException {

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return 0;
    }

    /**
     * Compares two geometrical forms and determines if they are in order.
     * @param geometricalForm
     * @return
     */

    public int compareTo(GeometricalForm geometricalForm) {
        return 0;
    }

    /**
     * Compares two objects with each other.
     * @param o Object to compare with.
     * @return True if the objects are identical except the position.
     */

    public boolean equals(Object o){
        return false;
    }

}
