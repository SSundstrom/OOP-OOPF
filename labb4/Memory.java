import javax.swing.*;
import java.awt.*;

public class Memory extends JFrame {

    public static void createCardSlots(int pairs, JFrame f) {

      JPanel box;

      for (int i = 0; i < pairs*2; i++) {
        box = new JPanel();
        box.setBackground(Color.yellow);
        box.setLayout(new GridLayout(4,4));
        f.add(box);
      }
    }

    public static int askWidth() {
      int totalPairs = 0;

      String nbrPairs = JOptionPane.showInputDialog("How many rows do you want?");

      try {
          totalPairs = Integer.parseInt(nbrPairs.trim());
      } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Please enter a number");
      }
      return totalPairs;
    }

    public static int askHeigth() {
      int totalPairs = 0;

      String nbrPairs = JOptionPane.showInputDialog("How many columns do you want?");

      try {
          totalPairs = Integer.parseInt(nbrPairs.trim());
      } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Please enter a number");
      }
      return totalPairs;
    }

    public static void createWindow() {

        int width =

        width *= 100;
        heigth *= 100;

        JFrame frame = new JFrame("Memory");
        frame.setBackground(Color.RED);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, heigth);
        frame.setLocation(100, 100);
        frame.setVisible(true);

        createCardSlots(totalPairs, frame);
    }

    public static void main(String[] args) {
        createWindow();
    }
}
