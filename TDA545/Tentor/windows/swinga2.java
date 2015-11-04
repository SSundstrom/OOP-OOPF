import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.AbstractButton;

public class swinga2 extends JFrame implements ActionListener {

  private static int x = 150;
  private static int y = 100;

  public static void main(String[] args) {
    swinga2 s = new swinga2();

  }

  public swinga2 () {
    this.setSize(100, 75);
    this.setLocation(x ,y);
    JPanel body = new JPanel();
    JButton ok = new JButton("Ok");
    this.add(body);
    body.setLayout(new FlowLayout());
    body.add(ok);
    this.setVisible(true);
    body.setVisible(true);
    ok.addActionListener(this);

  }

  public void actionPerformed(ActionEvent e) {

    if (x > 1000) {
      x = 0;
      y += 100;
    }
    x += 150;

    swinga2 s1 = new swinga2();

    if (x > 1000) {
      x = 0;
      y += 100;
    }
    x += 150;

    swinga2 s2 = new swinga2();

    this.setVisible(false);

  }


}
