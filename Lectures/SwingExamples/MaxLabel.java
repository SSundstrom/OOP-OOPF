import java.awt.*;
import javax.swing.*;

public class MaxLabel extends JLabel {

    public MaxLabel(String text) {
        super(text,SwingConstants.CENTER);
    }

    public void maximiseFont() {
        Font font = this.getFont();
        String text = this.getText();
        int maxWidth = this.getWidth();
        int maxHeight = this.getHeight();
        int stringWidth = this.getFontMetrics(font).stringWidth(text);
        int size = 3;
        while (true) {
            Font newFont = new Font(font.getName(), Font.PLAIN, size+1);
            int newWidth = this.getFontMetrics(newFont).stringWidth(text);
            if (maxWidth < newWidth) {
                break;
            }
            font = newFont;
            size++;
        }
        while (maxHeight < this.getFontMetrics(font).getHeight()) {
            size--;
            font = new Font(font.getName(), Font.PLAIN, size);
        }
        this.setFont(font);
    }

}
