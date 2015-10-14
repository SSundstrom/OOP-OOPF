import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
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
    private List<JLabel> playerScores;
    private List<JPanel> playerBox;
    private Timer t;
    private int playerTurn;
    private boolean active;
    private int removedPairs;

//    Konstruktorn för klassen memory.
//    Den initierar många av memorys klassvariabler

    public Memory() {
        rows = 0;
        columns = 0;
        visableCards = new Kort[2];
        spelare = new ArrayList<>();
        points = new ArrayList<>();
        playerScores = new ArrayList<>();
        playerBox = new ArrayList<>();
        t = new Timer(1500, this);
        active = true;
    }

//  actionPerformed tar in data från användaren och ger respons
//  beroende på datan den får in.

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(t)) {
            t.stop();
            if (visableCards[0].getRealIcon().equals(visableCards[1].getRealIcon())) {
                active = true;
                updateScore(playerTurn, true);
                visableCards[0].setStatus(Kort.Status.SAKNAS);
                visableCards[1].setStatus(Kort.Status.SAKNAS);
                visableCards[0] = null;
                visableCards[1] = null;
                removedPairs++;
                if (removedPairs == (rows*columns/2)) {
                    won();
                }

            } else {
                active = true;
                visableCards[0].setStatus(Kort.Status.DOLT);
                visableCards[1].setStatus(Kort.Status.DOLT);
                visableCards[0] = null;
                visableCards[1] = null;
                nextPlayer();
            }


        } else if (e.getSource().getClass() == Kort.class && active) {
            Kort k = (Kort) e.getSource();
            if (k.getStatus().equals(Kort.Status.DOLT)) {
                k.setStatus(Kort.Status.SYNLIGT);

                if (visableCards[0] == null) {
                    visableCards[0] = k;
                } else {
                    visableCards[1] = k;
                    active = false;
                    t.start();

                }
            }
        } else if (e.getSource().getClass() == JButton.class && active) {
            if (e.getSource().equals(avsluta)) {
                JOptionPane.showMessageDialog(null, "Hejdå!");
                System.exit(0);
            } else if (e.getSource().equals(nytt)) {
                nyttSpel();
            }
        }
    }

//  cards är en metod som tar in de bilder som ligger i
//  image mappen och gör dem tillgängliga för programmet

    public void cards() {
        File bildmapp = new File("image");
        File[] bilder = bildmapp.listFiles();
        k = new Kort[bilder.length];
        for (int i = 0; i < bilder.length; i++) {
            ImageIcon icon = new ImageIcon(bilder[i].getPath());
            Kort card = new Kort(icon);
            k[i] = card;

        }
    }

//  askSize är en metod som frågar användaren vilket
//  antal rader eller kolumner man vill ha
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

//  createWindow är en metod som skapar det fönster vi spelar i.
//  Den sätter även in spelarnamnen och skapar listor för informationen runt spelarna.

    public void createWindow() {

        int width;
        int height;

        do {

            do {
                width = askSize("columns");
            } while (width == 0);

            do {
                height = askSize("rows");
            } while ((width * height) % 2 != 0 || height == 0);

        } while (width*height > k.length*2);

        String p1 = JOptionPane.showInputDialog("Player 1 name?");
        String p2 = JOptionPane.showInputDialog("Player 2 name?");
        spelare.add(0, p1);
        spelare.add(1, p2);

        points.add(0, 0);
        points.add(1, 0);

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
        base.setBackground(Color.LIGHT_GRAY);
        base.setLayout(new BorderLayout());
        base.setVisible(true);
        frame.add(base);
        frame.setSize(width, height);

        JPanel options = new JPanel();
        options.setBackground(Color.LIGHT_GRAY);
        options.setPreferredSize(new Dimension(width, height / 10));
        options.setLayout(new GridLayout(1,2));
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
        gameboard.setBackground(Color.LIGHT_GRAY);
        gameboard.setLayout(new GridLayout(height/heightMod, width/widthMod));
        base.add(gameboard);

        nytt = new JButton("Nytt Spel");
        options.add(nytt);
        nytt.addActionListener(this);


        avsluta = new JButton("Avsluta");
        options.add(avsluta);
        avsluta.addActionListener(this);

    }

//  Skapar en ruta för att kunna visa informationen som här till en specifik spelare.

    public void scoreBoxes(int i, JPanel s) {
        JPanel box  = new JPanel();
        s.add(box);

        box.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        box.setLayout(new GridLayout(2,1));
        JPanel nameBox  = new JPanel();
        nameBox.setOpaque(false);
        box.add(nameBox);
        JPanel pointsBox  = new JPanel();
        pointsBox.setOpaque(false);
        box.add(pointsBox);

        JLabel name = new JLabel(spelare.get(i));
        name.setFont(new Font("Arial", Font.BOLD, 25));
        nameBox.add(name);
        JLabel score = new JLabel(points.get(i).toString());
        score.setFont(new Font("Arial", Font.PLAIN, 30));
        pointsBox.add(score);
        playerScores.add(i, score);
        playerBox.add(i, box);
    }
//  Medtod som kallas då spelet är slut

    public void won() {
        int j = -1;
        String winner = "";
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) >= j) {
                if (points.get(i) == j) {
                    winner += " & " + spelare.get(i);
                } else {
                    winner = spelare.get(i);
                }
                j = points.get(i);
            }
        }
        winner += " vann!\nHurra!\nSpela igen?";
        int temp = JOptionPane.showConfirmDialog(null, winner);
        if (temp == 0) {
            nyttSpel();
        } else {
            JOptionPane.showMessageDialog(null, "Hejdå!");
            System.exit(0);
        }
    }

//  Går vidare till nästa spelare i listan

    public void nextPlayer() {
        playerBox.get(playerTurn).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        playerBox.get(playerTurn).setBackground(Color.LIGHT_GRAY);
        playerTurn++;
        playerTurn = playerTurn%2;

        playerBox.get(playerTurn).setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 10));
        playerBox.get(playerTurn).setBackground(Color.WHITE);
    }

//  Gör 2 olika saker beroende på vilken boolean du ger den.
//  Om du ger den true så kommer den öka poängen för spelare i.
//  Om du ger den falskt så kommer den bara göra en uppdatering rutan som poängen visas i

    public void updateScore(int i, boolean sant) {
        if(sant) {
            int temp = points.get(i) + 1;
            points.set(i, temp);
            playerScores.get(i).setText(Integer.toString(temp));
        } else {
            playerScores.get(i).setText("0");
        }
        playerScores.get(i).repaint();
    }

//  Påbörjar ett nytt spel genom att välja ut bilder ur image mappen
//  och populera spelplanen med ett visst antal kort.
//  Den återställer även poängen för båda spelarna

    public void nyttSpel() {
        visableCards[0] = null;
        visableCards[1] = null;
        gameboard.setVisible(false);
        gameboard.removeAll();
        removedPairs = 0;
        points.set(0, 0);
        points.set(1, 0);
        Random r = new Random();
        playerTurn = r.nextInt(2);
        nextPlayer();

        int n = rows*columns;
        Kort[] cardsInPlay = new Kort[n];

        Verktyg.slumpOrdning(k);

        for (int i = 0; i < n/2; i++) {
            cardsInPlay[i] = k[i].copy();
            cardsInPlay[n-i-1] = k[i].copy();
        }

        Verktyg.slumpOrdning(cardsInPlay);

        for (Kort c : cardsInPlay) {
            gameboard.add(c);
            c.addActionListener(this);
            c.setStatus(Kort.Status.DOLT);
        }

        updateScore(0, false);
        updateScore(1, false);
        gameboard.updateUI();
        gameboard.setVisible(true);
    }


    public static void main(String[] args) {

        Memory m = new Memory();
        m.cards();
        m.createWindow();
        m.nyttSpel();


    }
}
