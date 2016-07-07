package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by php on 07/07/16.
 */
public class IconUtils {
    public static ImageIcon getImage(String imageName, int width, int height) {
        try {
            return new ImageIcon(getBufferedImage(imageName).getScaledInstance(width, height, BufferedImage.SCALE_REPLICATE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ImageIcon getImage(String imageName) {
        try {
            return new ImageIcon(getBufferedImage(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage getBufferedImage(String imageName) throws IOException {
        return ImageIO.read(IconUtils.class.getClass().getResourceAsStream("/images/" + imageName));
    }
}
