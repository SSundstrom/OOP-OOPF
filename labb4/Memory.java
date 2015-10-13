import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.Printable;
import java.io.File;
import java.util.*;
import java.util.List;

public class Memory implements ActionListener  {

    private Kort[] k;
    private int rows;
    private int columns;
    private JPanel gameboard;
    private JButton nytt;
    private JButton avsluta;
    private Kort[] visableCards;
    private List<String> spelare;
    private List<Integer> points;
    private Timer t;
    private int playerTurn;


    public Memory() {
        rows = 0;
        columns = 0;
        visableCards = new Kort[2];
        spelare = new ArrayList<>();
        points = new ArrayList<>();
        t = new Timer(1500, this);
    }

    public void actionPerformed(ActionEvent e) {
        t.stop();
        if (e.getSource().equals(t)) {
            if (visableCards[0].equals(visableCards[1])) {
                int i = points.get(playerTurn) + 1;
                points.set(playerTurn, i);
            } else {
                visableCards[0].setStatus(Kort.Status.DOLT);
                visableCards[1].setStatus(Kort.Status.DOLT);
                visableCards[0] = null;
                visableCards[1] = null;
                nextPlayer();
            }

        } else if (e.getSource().getClass() == Kort.class) {
            Kort k = (Kort)e.getSource();
            k.setStatus(Kort.Status.SYNLIGT);

            if (visableCards[0] == null) {
                visableCards[0] = k;
            } else {
                visableCards[1] = k;
                t.start();
            }
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
    public void nextPlayer() {
        playerTurn++;
        playerTurn = playerTurn%2;

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

        String p1 = JOptionPane.showInputDialog("Player 1 name?");
        String p2 = JOptionPane.showInputDialog("Player 2 name?");
        spelare.add(0, p1);
        spelare.add(1, p2);

        points.add(0, 0);
        points.add(1, 0);

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
        score.setLayout(new GridLayout(spelare.size(), 1));
        base.add(score, BorderLayout.WEST);
        scoreBoxes(0, score);
        scoreBoxes(1, score);

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

    public void scoreBoxes(int i, JPanel s) {
        JPanel box  = new JPanel();
        s.add(box);
        box.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        box.setLayout(new GridLayout(2,1));
        JPanel nameBox  = new JPanel();
        box.add(nameBox);
        JPanel pointsBox  = new JPanel();
        box.add(pointsBox);

        JLabel name = new JLabel(spelare.get(i));
        name.setFont(new Font("Arial", Font.BOLD, 25));
        nameBox.add(name);
        JLabel score = new JLabel(points.get(i).toString());
        score.setFont(new Font("Arial", Font.PLAIN, 30));
        pointsBox.add(score);
    }


    public void nyttSpel() {

        points.add(0, 0);
        points.add(1, 0);
        Random r = new Random();
        playerTurn = r.nextInt(2);

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
