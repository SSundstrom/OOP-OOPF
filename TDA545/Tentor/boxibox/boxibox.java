import javax.swing.*;
import java.awt.*;

public class boxibox extends JFrame {

  class box extends JPanel {

    public box() {
      super();
    }

    public box(int width, int height) {
      this();
      setSize(width, height);
    }

    public void drawRect(Graphics g, int x, int y, int width, int height) {
      g.drawRect(x,y,width,height);
    }

    public void paintComponent(Graphics g) {
      g.drawRect(5, 5, getWidth()-10, getHeight()-10);
      g.setColor(Color.black);

    }
  }

  public boxibox() {
    super();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setLocation(100,100);
    setVisible(true);
    add(new box());


  }
  public static void main(String[] args) {
    new boxibox();

  }
}
