import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class YellowBluePanel extends JPanel
                      implements ActionListener {
    boolean isBlue = false;
    public YellowBluePanel() {
        this.setBackground(Color.yellow);
    }
    public void actionPerformed(ActionEvent e) {
        if (isBlue) {
            this.setBackground(Color.yellow);
            isBlue = false;
        } else {
            this.setBackground(Color.blue);
            isBlue = true;
        }
    }
}

public class Demo16 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo 16");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,120);
        YellowBluePanel myPanel = new YellowBluePanel();
        myPanel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Byt färg");
        button1.addActionListener(myPanel);
        myPanel.add(button1);
        f.add(myPanel);
        f.setVisible(true);
    }
}
