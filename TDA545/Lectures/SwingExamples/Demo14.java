import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class DemoListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("Hej!");
    }

}

public class Demo14 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo 14");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,120);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout());
        myPanel.setBackground(Color.yellow);
        JButton button1 = new JButton("Knapp");
        button1.addActionListener(new DemoListener());
        myPanel.add(button1);
        f.add(myPanel);
        f.setVisible(true);
    }
}
