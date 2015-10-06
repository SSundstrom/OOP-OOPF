import java.awt.*;
import javax.swing.*;

public class Demo7 {
    public static void main(String[] args) {
        // skapar en 'frame' (dvs ett fönster)
        JFrame f = new JFrame("Demo 7");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(350,150);
        f.setLocation(50,50);
        // skapa en panel
        JPanel myPanel = new JPanel();
        myPanel.setBackground(Color.yellow);
        myPanel.setLayout(new BorderLayout());
        // sätt knappar in i panelen
        JButton buttonN = new JButton("Nord");
        JButton buttonW = new JButton("Väst");
        JButton buttonC = new JButton("Centrum");
        myPanel.add(buttonN,BorderLayout.NORTH);
        myPanel.add(buttonW,BorderLayout.WEST);
        myPanel.add(buttonC,BorderLayout.CENTER);
        // sätt panelen in i f
        f.add(myPanel);
        f.pack();
        // visa ramen
        f.setVisible(true);
    }
}
