package lab1;

import java.awt.*;

/**
 * Created by simsund on 2015-11-11.
 */
public class BodyTile extends GameTile {
    private final Color backColor;
    private final Color zigZagColor;

    public BodyTile(final Color bC, final Color zZC) {
        this.backColor = bC;
        this.zigZagColor = zZC;
    }

    @Override
    public void draw(final Graphics g,final int x,final int y,final Dimension d) {
        g.setColor(this.backColor);
        g.fillRect(x, y ,d.width, d.height);
        g.setColor(this.zigZagColor);
        g.drawLine(d.width/2, 0, d.width/4, d.height/4);
    }
}
