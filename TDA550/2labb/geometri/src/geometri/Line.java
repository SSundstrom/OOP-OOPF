package geometri;
import java.awt.*;

/**
 * Represents a drawable Line
 */
public class Line implements GeometricalForm {

    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private Color color;

    /**
     * Initialize a new Line.
     * @param x1 Start coordinate in x.
     * @param y1 Start coordinate in y.
     * @param x2 End coordinate in x.
     * @param y2 End coordinate in y.
     * @param c Color of the Line.
     * @throws IllegalPositionException Exception if coordinates is invalid.
     */
    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{
        this.xStart = x1;
        this.xEnd = x2;
        this.yStart = y1;
        this.yEnd = y2;
        this.color = c;
    }

    /**
     * Initialize a new Line from two excising GeometricalForms.
     * @param f1 GeometricalForm to get start coordinates.
     * @param f2 GeometricalForm to get end coordinates.
     * @param c Color of the Line.
     */
    public Line(GeometricalForm f1, GeometricalForm f2, Color c){
        this.xStart = f1.getX();
        this.xEnd = f2.getX();
        this.yStart = f1.getY();
        this.yEnd = f2.getY();
        this.color = c;
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
    public Color getColor() {
        return null;
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
    public int getHeight() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPerimeter() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWidth() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(int dx, int dy) throws IllegalPositionException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void place(int x, int y) throws IllegalPositionException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(GeometricalForm geometricalForm) {
        return 0;
    }

    /**
     * Compares two objects with each other.
     * @param o Object to compare with.
     * @return True if the objects are identical except the position.
     */
    @Override
    public boolean equals(Object o){
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode(){
        return 0;
    }
}
