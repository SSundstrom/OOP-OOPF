package lab1;

import java.awt.*;

public class BodyTileVertical extends GameTile {
    private final Color backColor;
    private final Color zigZagColor;

    /**
     * Initziating the colors.
     * @param bC
     *              the background color
     * @param zZC
     *              the pattern color
     */
    public BodyTileVertical(final Color bC, final Color zZC) {
        this.backColor = bC;
        this.zigZagColor = zZC;
    }

    /**
     * Draws a bodypart with a pattern.
     * @param g
     *            graphics context to draw on.
     * @param x
     *            pixel x coordinate of the tile to be drawn.
     * @param y
     *            pixel y coordinate of the tile to be drawn.
     * @param d
     *            the dimension of the tile.
     */
    @Override
    public void draw(final Graphics g,final int x,final int y,final Dimension d) {
        g.setColor(this.backColor);
        g.fillRect(x, y ,d.width, d.height);
        g.setColor(this.zigZagColor);

        g.drawLine(x + d.width/3, y + d.height/5, x + d.width*2/3, y + d.height*2/5);
        g.drawLine(x + d.width/3, y + d.height*3/5, x + d.width*2/3, y + d.height*4/5);
    }
}
