import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame {

  class window extends JPanel implements MouseListener, ActionListener {
    private int x;
    private int y;
    private Graphics g;

    public window() {
      super();
      x = -20;
      y = -20;
      addMouseListener(this);
      setLayout(new BorderLayout());
      JButton button = new JButton("Exit");
      add(button);
      button.addActionListener(this);
      button.setActionCommand("exit");
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.red);
      g.fillRect(x-10, y-10, 20, 20);
      setBackground(Color.blue);

    }

    public void actionPerformed(ActionEvent e) {

      if (e.getActionCommand().equals("exit")) {
        System.exit(0);
      }
    }


    public void mouseClicked(MouseEvent e){
      x = e.getX();
      y = e.getY();
      repaint();
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}


  }


  public Main() {
    super();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setSize(500,500);
    setLocation(200,200);
    setVisible(true);
    add(new window());
  }

  public static void main(String[] args) {
    new Main();
  }
}
