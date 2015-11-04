import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class YellowBluePanel18 extends JPanel
                        implements ActionListener {
    public YellowBluePanel18() {
        this.setBackground(Color.yellow);
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            JButton b = (JButton) obj;
            String str = b.getText();
            if (str.equals("Gul")) {
                this.setBackground(Color.yellow);
            } else if (str.equals("Blå")) {
                this.setBackground(Color.blue);
            }
        }
    }
}

public class Demo18 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo 17");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,120);
        YellowBluePanel18 myPanel = new YellowBluePanel18();
        myPanel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Gul");
        button1.addActionListener(myPanel);
        myPanel.add(button1);
        JButton button2 = new JButton("Blå");
        button2.addActionListener(myPanel);
        myPanel.add(button2);
        f.add(myPanel);
        f.setVisible(true);
    }
}
