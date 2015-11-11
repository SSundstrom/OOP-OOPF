package lab1;

import java.awt.*;

/**
 * Created by simsund on 2015-11-11.
 */
public class BodyTileVertical extends GameTile {
    private final Color backColor;
    private final Color zigZagColor;

    public BodyTileVertical(final Color bC, final Color zZC) {
        this.backColor = bC;
        this.zigZagColor = zZC;
    }

    @Override
    public void draw(final Graphics g,final int x,final int y,final Dimension d) {
        g.setColor(this.backColor);
        g.fillRect(x, y ,d.width, d.height);
        g.setColor(this.zigZagColor);
        /*
        g.drawLine(x + d.width/2, y , x+d.width/4, y+d.height/6);
        g.drawLine(x + d.width/4, y + d.height/6, x+d.width*3/4, y+d.height/4);
        g.drawLine(x + d.width*3/4, y + d.height/4, x + d.width/4, y + d.height/2);
        g.drawLine(x + d.width/4, y + d.height/2, x + d.width*3/4, y + d.height*3/4);
        g.drawLine(x + d.width*3/4, y + d.height*3/4, x + d.width/4, y + d.height*5/6);
        */
        g.drawLine(x + d.width/3, y + d.height/5, x + d.width*2/3, y + d.height*2/5);
        g.drawLine(x + d.width/3, y + d.height*3/5, x + d.width*2/3, y + d.height*4/5);
    }
}
