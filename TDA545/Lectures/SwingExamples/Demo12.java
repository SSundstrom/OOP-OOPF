import java.awt.*;
import javax.swing.*;

public class Demo12 {
    public static void main(String[] args) {
        // skapar en 'frame' (dvs ett fönster)
        JFrame f = new JFrame("Demo 12");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,120);
        f.setLocation(50,50);
        // skapa en panel
        JPanel myPanel = new JPanel();
        myPanel.setBackground(Color.yellow);
        myPanel.setLayout(new GridLayout(3,1));
        // sätt olika saker i panelen
        JLabel label = new JLabel(" Skriv en siffra: ");
        JTextField text = new JTextField("57");
        JButton button = new JButton("Skicka!");
        myPanel.add(label);
        myPanel.add(text);
        myPanel.add(button);
        // sätt panelen in i f
        f.add(myPanel);
        // visa ramen
        f.setVisible(true);
    }
}
