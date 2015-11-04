import java.awt.*;
import javax.swing.*;

public class Demo11 {
    public static void main(String[] args) {
        // skapar en 'frame' (dvs ett fönster)
        JFrame f = new JFrame("Demo 11");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(350,150);
        f.setLocation(50,50);
        // skapa en panel
        JPanel myPanel = new JPanel();
        myPanel.setBackground(Color.yellow);
        myPanel.setLayout(new GridLayout(3,2));
        // sätt knappar in i panelen
        JButton button1 = new JButton("Knapp 1");
        JButton button2 = new JButton("Knapp 2");
        JButton button3 = new JButton("Knapp 3");
        JButton button4 = new JButton("Knapp 4");
        JButton button5 = new JButton("Knapp 5");
        myPanel.add(button1);
        myPanel.add(button2);
        myPanel.add(button3);
        myPanel.add(button4);
        myPanel.add(button5);
        // sätt panelen in i f
        f.add(myPanel); f.pack();
        // visa ramen
        f.setVisible(true);
    }
}
