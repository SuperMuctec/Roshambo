import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RoshamboGui window = null;
                try {
                    window = new RoshamboGui();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                window.setVisible(true);
            }
        });
    }
}
