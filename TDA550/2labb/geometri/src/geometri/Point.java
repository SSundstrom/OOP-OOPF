package geometri;

import java.awt.*;

/**
 * Created by simsund on 2015-11-17.
 */
public class Point implements GeometricalForm {

    public Point(int x, int y, Color c) throws IllegalPositionException
    public Point(GeometricalForm f, Color c)

    @Override
    public void fill(Graphics g) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int getArea() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getPerimeter() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void move(int dx, int dy) throws IllegalPositionException {

    }

    @Override
    public void place(int x, int y) throws IllegalPositionException {

    }

    @Override
    public int compareTo(GeometricalForm geometricalForm) {
        return 0;
    }
}
