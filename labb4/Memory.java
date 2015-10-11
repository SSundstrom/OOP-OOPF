import javax.swing.*;

public class Memory {
    public static void createWindow() {
        int totalPairs = 0;
        String nbrPairs = JOptionPane.showInputDialog("How many pairs do you want?");
        try {
            totalPairs = Integer.parseInt(nbrPairs.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number");
        }
        int width = (int)Math.sqrt(totalPairs*2);
        int height = totalPairs/width;

        width *= 75;
        height *= 75;

        JFrame frame = new JFrame("Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createWindow();
    }
}
