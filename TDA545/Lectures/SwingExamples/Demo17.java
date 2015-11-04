import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class YellowBluePanel17 extends JPanel
                        implements ActionListener {
    public YellowBluePanel17() {
        this.setBackground(Color.yellow);
    }
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("yellow")) {
            this.setBackground(Color.yellow);
        } else if (str.equals("blue")) {
            this.setBackground(Color.blue);
        }
    }
}

public class Demo17 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo 17");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,120);
        YellowBluePanel17 myPanel = new YellowBluePanel17();
        myPanel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Gul");
        button1.addActionListener(myPanel);
        button1.setActionCommand("yellow");
        myPanel.add(button1);
        JButton button2 = new JButton("Blå");
        button2.addActionListener(myPanel);
        button2.setActionCommand("blue");
        myPanel.add(button2);
        f.add(myPanel);
        f.setVisible(true);
    }
}
