package geometri;
import java.awt.*;

/**
 * Represents a drawable Point
 */
public class Oval implements GeometricalForm{

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

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
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = c;
    }

    /**
     * Initialize a new Oval from an existing GeometricalForm.
     * @param f The GeometricalForm to get coordinates from.
     * @param width The width of the Oval.
     * @param height The height of the Oval.
     * @param c The color of Oval.
     */
    public Oval(GeometricalForm f, int width, int height, Color c){
        this.x = f.getX();
        this.y = f.getY();
        this.height = height;
        this.width = width;
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
