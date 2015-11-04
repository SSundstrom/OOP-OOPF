import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.AbstractButton;

public class swinga implements ActionListener {

  private static int x = 150;
  private static int y = 100;

  public static void main(String[] args) {
    swinga s = new swinga();
    s.fuckYou();
  }

  public void fuckYou() {
    JFrame frame = new JFrame();
    JPanel body = new JPanel();
    JButton ok = new JButton("Ok");
    frame.add(body);
    frame.setSize(100, 75);
    frame.setLocation(x, y);
    body.setLayout(new FlowLayout());
    body.add(ok);
    frame.setVisible(true);
    body.setVisible(true);
    ok.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e) {



    if (x > 1000) {
      x = 0;
      y += 100;
    }
    x += 150;

    fuckYou();

    if (x > 1000) {
      x = 0;
      y += 100;
    }
    x += 150;

    fuckYou();
  }


}
