// a) JFrame är en klass som skapar ett fönster och kan inehålla andra element.
// b) Timer håller reda på tiden.
import javax.swing.*;
import java.awt.event.*;


public class SnapFrame extends JFrame implements ActionListener {
  private Timer t;
  private boolean seen;

  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
    if (e.getActionCommand().equals("Timer")) {
      t.stop();
      super.setVisible(false);

    } else {
      System.out.println("Somthing went wrong");
      super.setVisible(false);
      t.stop();
    }

  }

  public SnapFrame() {
    super();
    seen = false;
    setSize(100, 100);
    setLocation(50,50);
  }

  @Override
  public void setVisible(boolean b){
    if (!seen) {
      super.setVisible(b);
      t = new Timer(5000, this);
      t.setActionCommand("Timer");
      t.start();
      seen = true;
    } else if (!b) {
      super.setVisible(false);
    }
  }
}
