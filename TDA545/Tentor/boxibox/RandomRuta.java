import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RandomRuta extends JFrame {
  private Random r;
  public RandomRuta() {
    super();
    r = new Random();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setLocation(100, 100);
    setVisible(true);
    add(new j());
  }

  class j extends JPanel {
    public j() {
      super();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (int i = 0; i < 25000; i++) {
        int x = r.nextInt(getWidth());
        int y = r.nextInt(getHeight());
        g.setColor(Color.black);
        g.fillRect( x, y, 2, 2);
      }
    }



  }
    public static void main(String[] args) {
      new RandomRuta();
    }
}
