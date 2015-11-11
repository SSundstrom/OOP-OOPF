package lab1;

import java.awt.*;

public class HeadTile extends GameTile{
    private Color background;
    private Color tounge;
    private Color eyes;
    private Color pupils;

   public HeadTile(){
       this.tounge = Color.RED;
       this.background = new  Color(32,83,32);
       this.eyes = Color.WHITE;
       this.pupils = Color.BLACK;
   }

    @Override
    public void draw(Graphics g, int x, int y, Dimension d) {
        super.draw(g, x, y, d);
        g.setColor(this.background);
        g.fillRect(x,y,d.width,d.height);
        g.setColor(this.eyes);
        g.fillOval(x + d.width/2, y + 5, 12, 12);
        g.fillOval(x + 6, y + 5, 12, 12);
        g.setColor(this.pupils);
        g.fillOval(x + d.width/2 + 1, y + 7, 6, 6);
        g.fillOval(x + 9, y + 7, 6, 6);
        g.setColor(tounge);
        g.fillRect(x + d.width/2 - 3, y + d.height - 6, 6,20);
        g.setColor(this.eyes);
        g.fillOval(x + d.width / 2 - 7, y + d.height - 12, 15, 10);
        g.setColor(this.background);
        g.fillOval(x + d.width/2 - 7,y + d.height - 14, 15, 10);
    }
}
