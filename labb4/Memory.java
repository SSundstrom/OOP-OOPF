import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Memory implements ActionListener  {

    private Kort[] k;
    private int rows;
    private int columns;
    private JPanel gameboard;
    private JButton nytt;
    private JButton avsluta;


    public Memory() {
        rows = 0;
        columns = 0;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().getClass());
        if (e.getSource().getClass() == Kort.class) {
            Kort k = (Kort)e.getSource();
            k.setStatus(Kort.Status.SYNLIGT);
        } else if (e.getSource().getClass() == JButton.class) {
            if (e.getSource().equals(avsluta)) {
                JOptionPane.showMessageDialog(null, "Hejdå!");
                System.exit(0);
            } else if (e.getSource().equals(nytt)) {
                gameboard.setVisible(false);
                gameboard.removeAll();
                nyttSpel();
            }
        }
    }

    public void cards() {
        File bildmapp = new File("image");
        File[] bilder = bildmapp.listFiles();
        k = new Kort[bilder.length];
        for (int i = 0; i < bilder.length; i++) {
            System.out.println(bilder[i].getPath());
            ImageIcon icon = new ImageIcon(bilder[i].getPath());
            Kort card = new Kort(icon);
            k[i] = card;

        }
    }


    public int askSize(String s) {
        int width = 0;
        String stringWidth = JOptionPane.showInputDialog("How many " + s + " do you want?");
        if (stringWidth == null) {
            System.exit(0);
        }
        try {
            width = Integer.parseInt(stringWidth.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number");
        }
        return width;
    }
    public void createWindow() {
        int width;
        int height;

        do {
          width = askSize("columns");
        } while (width == 0);

        do {
          height = askSize("rows");
        } while (height == 0);

        int pairs = width*height;
        rows = height;
        columns = width;
        int widthMod = 140;
        int heightMod = 120;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.setVisible(true);
        height = height * heightMod;
        width = width * widthMod;
        JPanel base = new JPanel();
        base.setBackground(Color.yellow);
        base.setLayout(new BorderLayout());
        base.setVisible(true);
        frame.add(base);
        frame.setSize(width, height);

        JPanel options = new JPanel();
        options.setBackground(Color.ORANGE);
        options.setPreferredSize(new Dimension(width, height / 10));
        options.setLayout(new FlowLayout());
        base.add(options, BorderLayout.SOUTH);
        options.setVisible(true);

        JPanel score = new JPanel();
        score.setPreferredSize(new Dimension(width / 4, height - height/10));
        score.setBackground(Color.BLUE);
        base.add(score, BorderLayout.WEST);
        score.setVisible(true);

        gameboard = new JPanel();
        gameboard.setSize(width, height);
        gameboard.setBackground(Color.PINK);
        gameboard.setLayout(new GridLayout(height/heightMod, width/widthMod));
        base.add(gameboard);

        nytt = new JButton("Nytt Spel");
        nytt.setPreferredSize(new Dimension(width/5, height/20));
        options.add(nytt);
        nytt.addActionListener(this);


        avsluta = new JButton("Avsluta");
        nytt.setPreferredSize(new Dimension(width/5, height/20));
        options.add(avsluta);
        avsluta.addActionListener(this);

    }


    public void nyttSpel() {
        int n = rows*columns;
        Kort[] cardsInPlay = new Kort[n];

        Verktyg.slumpOrdning(k);

        for (int i = 0; i < n/2; i++) {
            cardsInPlay[i] = k[i].copy();
            cardsInPlay[n-i-1] = k[i].copy();
        }

        Verktyg.slumpOrdning(cardsInPlay);
        int i = 0;

        for (Kort c : cardsInPlay) {
            i++;
            System.out.println(i);
            gameboard.add(c);
            c.addActionListener(this);
            c.setStatus(Kort.Status.DOLT);
        }
        gameboard.setVisible(true);
    }


    public static void main(String[] args) {
        Memory m = new Memory();
        m.cards();
        m.createWindow();
        m.nyttSpel();


    }
}
