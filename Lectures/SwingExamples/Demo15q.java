import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Demo15Listener implements ActionListener {
    JPanel myPanel;
    boolean isBlue = false;
    public Demo15Listener(JPanel myPanel) {
        this.myPanel = myPanel;
    }
    public void actionPerformed(ActionEvent e) {
        if (isBlue) {
            myPanel.setBackground(Color.yellow);
            isBlue = false;
        } else {
            myPanel.setBackground(Color.blue);
            isBlue = true;
        }
    }
}

public class Demo15q {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo 15");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,120);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout());
        myPanel.setBackground(Color.yellow);
        JButton button1 = new JButton("Byt färg");
        button1.addActionListener(new Demo15Listener(myPanel));
        myPanel.add(button1);
        f.add(myPanel);
        f.setVisible(true);
    }
}
