import java.awt.*;
import javax.swing.*;

public class FullScreenFrame extends JFrame {

    private GraphicsDevice device;

    public FullScreenFrame() {
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = ge.getDefaultScreenDevice();
    }

    public void showFullScreen() {
        if (device.isFullScreenSupported()) {
            setUndecorated(true);
            device.setFullScreenWindow(this);
        } else {
            System.err.println("Full screen not supported.");
            System.exit(1);
        }
    }

}
