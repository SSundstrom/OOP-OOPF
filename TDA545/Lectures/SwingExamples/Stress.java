import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Stress implements ActionListener {

    JLabel timeLabel;

    private int mode = 2;

    public void toggle() {
        mode = (mode + 2) % 3;
    }

    public Stress() {

    	FullScreenFrame ff = new FullScreenFrame();
        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.setBackground(Color.BLACK);
        MaxLabel label1 = new MaxLabel(" Men det är ju bara ");
        MaxLabel label2 = new MaxLabel(" " + timeLeftSecs() + " ");
        MaxLabel label3 = new MaxLabel(" sekunder till tentan! ");
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        ff.add(panel);

 	ff.validate();
        ff.showFullScreen();

        label1.maximiseFont();
        label2.maximiseFont();
        label3.maximiseFont();

        timeLabel = label2;
        Timer t = new Timer(10,this);
        t.start();

        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.YELLOW);
        label3.setForeground(Color.WHITE);

        label1.addMouseListener(new StressExit());
        label2.addMouseListener(new StressMode(this));
        label3.addMouseListener(new StressExit());

    }

    public String timeLeftSecs() {
        LocalDateTime tentan = LocalDateTime.of(2015,10,29,14,00,00);
        LocalDateTime nu = LocalDateTime.now();
        long left = nu.until(tentan,ChronoUnit.MILLIS);
        if (mode == 0) {
            return "" + (left / 1000);
        } else if (mode == 1) {
            return (left / 1000) + "," + ((left / 100) % 10);
        } else {
            if ((left / 10) % 100 < 10) {
                return (left / 1000) + ",0" + ((left / 10) % 100);
            } else {
                return (left / 1000) + "," + ((left / 10) % 100);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        timeLabel.setText(" " + timeLeftSecs() + " ");
    }

    public static void main (String [] args) {
        Stress s = new Stress();
    }

}

class StressMode implements MouseListener {

    Stress s;

    public StressMode(Stress t) {
        s = t;
    }

    public void mouseClicked(MouseEvent e) {
        s.toggle();
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

}

class StressExit implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

}
