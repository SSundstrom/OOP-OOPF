package geometri;

import java.awt.*;
public interface GeometricalForm extends Comparable<GeometricalForm> {
    public void fill(Graphics g);
    public Color getColor();
    public int getArea();
    public int getHeight();
    public int getPerimeter();
    public int getWidth();
    public int getX();
    public int getY();
    public void move(int dx, int dy) throws IllegalPositionException;
    public void place(int x, int y) throws IllegalPositionException;
}