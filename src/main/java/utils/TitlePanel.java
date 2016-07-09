package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by php on 09/07/16.
 */
public class TitlePanel extends JPanel {
    private BufferedImage icon;
    private JLabel jLabel;

    public TitlePanel(BufferedImage image, String label) {
        this.icon = (BufferedImage) image.getScaledInstance(Image.SCALE_SMOOTH, 60, 60);
        this.jLabel = new JLabel(label);
        this.setPreferredSize(new Dimension());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.icon, 0, 0, null);
        this.jLabel.paint(graphics);
    }
}
