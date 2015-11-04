import java.awt.*;
import javax.swing.*;

public class Demo4 {
    public static void main(String[] args) {
        // skapar en 'frame' (dvs ett fönster)
        JFrame f = new JFrame("Demo 4");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,200);
        f.setLocation(50,50);
        // skapa en panel
        JPanel myPanel = new JPanel();
        myPanel.setBackground(Color.yellow);
        myPanel.setLayout(new BorderLayout());
        // sätt en knapp in i panelen
        JButton button1 = new JButton("Knapp 1");
        myPanel.add(button1,BorderLayout.NORTH);
        // sätt panelen in i f
        f.add(myPanel);
        // visa ramen
        f.setVisible(true);
    }
}
