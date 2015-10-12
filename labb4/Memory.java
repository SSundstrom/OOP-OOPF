import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Memory extends JFrame {

    public class cards {
        File bildmapp = new File("bildmapp");
        File[] bilder = bildmapp.listFiles();
    }

    public static void createCardSlots(int cards, JPanel f) {
        JPanel box;

        for (int i = 0; i < cards; i++) {
            box = new JPanel();
            box.setBackground(Color.red);
            box.setBorder(BorderFactory.createLineBorder(Color.black));
            f.add(box);
        }
    }

    public static int askSize(String s) {
        int width = 0;
        String stringWidth = JOptionPane.showInputDialog("How many " + s + " do you want?");
        if (stringWidth == null) {
            System.exit(0);
        }
        try {
            width = Integer.parseInt(stringWidth.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number");
        }
        return width;
    }
    public static void createWindow() {
        int width;
        int height;

        do {
          width = askSize("columns");
        } while (width == 0);

        do {
          height = askSize("rows");
        } while (height == 0);

        int pairs = width*height;


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.setVisible(true);
        height = height * 100;
        width = width * 100;
        JPanel base = new JPanel();
        base.setBackground(Color.yellow);
        base.setLayout(new BorderLayout());
        base.setVisible(true);
        frame.add(base);
        frame.setSize(width, height);

        JPanel options = new JPanel();
        options.setBackground(Color.ORANGE);
        base.add(options, BorderLayout.SOUTH);

        JPanel score = new JPanel();
        score.setPreferredSize(new Dimension(width / 4, height - 40));
        score.setBackground(Color.BLUE);
        base.add(score, BorderLayout.WEST);

        JPanel gameboard = new JPanel();
        gameboard.setSize(width, height);
        gameboard.setBackground(Color.PINK);
        base.add(gameboard);
//        createCardSlots(pairs, gameboard);
    }
    public static void nyttSpel() {

    }

    public static void main(String[] args) {
        createWindow();

    }
}
