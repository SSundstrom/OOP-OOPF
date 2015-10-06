import java.awt.*;
import javax.swing.*;

public class Demo13 {
    public static void main(String[] args) {
        // skapar en 'frame' (dvs ett fönster)
        JFrame f = new JFrame("Demo 13");
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
        myPanel.add(label);
        myPanel.add(text);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.green);
        buttonPanel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Skicka!");
        JButton button2 = new JButton("Avbryt");
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        myPanel.add(buttonPanel);
        // sätt panelen in i f
        f.add(myPanel);
        // visa ramen
        f.setVisible(true);
    }
}
