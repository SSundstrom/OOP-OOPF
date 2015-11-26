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

    /**
     * Initialize a new shape
     * @param x Coordinate in x
     * @param y Coordinate in y
     * @param width width of the shape
     * @param height height of the shape
     * @param c color of the shape
     * @throws IllegalPositionException if out of bounds
     */
    public AbstractGeometricalForm( int x, int y, int width, int height, Color c) throws IllegalPositionException {
        if (x < 0 || y < 0) {
            throw new IllegalPositionException("Out of Bounds");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = c;

    }

    /**
     * Initialize a shape
     * @param f Geometricalform to use
     * @param width width of shape
     * @param height height of shape
     * @param c color of shape
     */
    public AbstractGeometricalForm(GeometricalForm f, int width, int height, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.width = width;
        this.height = height;
        this.color = c;
    }

    /**
     * {@inheritDoc}
     */
    public int getX() {
        return this.x;
    }
    /**
     * {@inheritDoc}
     */
    public int getY() {
        return this.y;
    }
    /**
     * {@inheritDoc}
     */
    public Color getColor() {
        return new Color(color.getRGB());
    }

    /**
     * {@inheritDoc}
     */
    public void move(int dx, int dy) throws IllegalPositionException {
        if(dx < 0 || dy < 0){
            throw new IllegalPositionException("No negative values please.");
        }
        this.x = this.x + dx;
        this.y = this.y + dy;

    }

    /**
     * {@inheritDoc}
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * {@inheritDoc}
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * {@inheritDoc}
     */
    public void place(int x, int y) throws IllegalPositionException {
        if( x < 0 || y < 0){
            throw new IllegalPositionException("No negative values.");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return this.width * 2 + this.height * 3 + this.color.hashCode() * 5;
    }

    /**
     * {@inheritDoc}
     */

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o.getClass() == null || this.getClass() != o.getClass()){
            return false;
        }
        AbstractGeometricalForm tmp = (AbstractGeometricalForm) o;
        return (this.color.equals(tmp.getColor()) &&
                this.width == tmp.getWidth() &&
                this.height == tmp.getHeight());
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(GeometricalForm f) {

        int diff = this.getArea() - f.getArea();

        if (diff != 0) {
            return diff;
        }

        return this.getPerimeter() - f.getPerimeter();

    }

}
