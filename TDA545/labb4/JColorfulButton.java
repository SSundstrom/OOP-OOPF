import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JColorfulButton extends JLabel
        implements MouseListener {

    ActionListener al = null;
    String ac = null;

    public JColorfulButton() {
        super("",SwingConstants.CENTER);
        setOpaque(true);
        addMouseListener(this);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public JColorfulButton(Icon i) {
        super(i,SwingConstants.CENTER);
        setOpaque(true);
        addMouseListener(this);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setFocusPainted(boolean b) {}

    public void addActionListener(ActionListener al) {
        this.al = al;
    }

    public void setActionCommand(String ac) {
        this.ac = ac;
    }

    public void mouseClicked(MouseEvent e) {
        if (al != null) {
            ActionEvent ae = new ActionEvent(e.getSource(),e.getID(),ac);
            al.actionPerformed(ae);
        }
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public static final long serialVersionUID = 0;

}
