import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {

    public Main() {
    	JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,120);
        f.setLocation(50,50);
        JPanel panel = new JPanel(new GridLayout(2,1));
        JLabel label1 = new JLabel("Vill du lära dig Java?", SwingConstants.CENTER);
        panel.add(label1);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton button1 = new JButton("Ja!");
        JButton button2 = new JButton("Kanske lite senare...");
        button1.addActionListener(this);
        button1.setActionCommand("yes");
        button2.addActionListener(this);
        button2.setActionCommand("no");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        panel.add(buttonPanel);
        f.add(panel);
        f.pack();
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("yes")) {
            System.exit(0);
        } else if (str.equals("no")) {
            Stress s = new Stress();
        }
    }

    public static void main (String [] args) {
        Main q = new Main();
    }

}
