

  import javax.swing.*;
  import java.awt.*;

  public class Main extends JFrame {
      private class PatternPanel extends JPanel {
          public PatternPanel() {
              super();
          }

          private static final int OFFSET = 4;

          private void drawRect(Graphics g, int x, int y, int width, int height) {
              g.drawRect(x, y, width, height);

              if (width > OFFSET * 6) {
                  drawRect(g, x + OFFSET, y + OFFSET, width / 2 - OFFSET*2, height - OFFSET*2);
                  drawRect(g, x + OFFSET + width / 2, y + OFFSET, width / 2 - OFFSET*2, height - OFFSET*2);
              }
          }

          @Override
          public void paintComponent(Graphics g) {
              drawRect(g, 0, 0, getWidth(), getHeight());
          }
      }

      public Main() {
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(500,250);
          add(new PatternPanel());
          setVisible(true);
      }

      public static void main(String[] args) {
          new Main();
      }
  }
