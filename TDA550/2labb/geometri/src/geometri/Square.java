package geometri;
import java.awt.*;

/**
 * Represents a drawable Square
 */
public class Square implements GeometricalForm{

    private int x;
    private int y;
    private int side;
    private Color color;

    /**
     * Initialize a new square on defined position, size and color.
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     * @param side Size of ever side.
     * @param c Color of square.
     * @throws IllegalPositionException Exception if position is illegal.
     */
    public Square(int x, int y, int side, Color c) throws IllegalPositionException{
        this.x = x;
        this.y = y;
        this.side = side;
        this.color = c;
    }

    /**
     * Initialize a new square from an existing GeometricalForm.
     * @param f GeometricalForm to get coordinates from.
     * @param side Size of side.
     * @param c Color of square.
     */
    public Square(GeometricalForm f, int side, Color c){
        this.x = f.getX();
        this.y = f.getY();
        this.side = side;
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
