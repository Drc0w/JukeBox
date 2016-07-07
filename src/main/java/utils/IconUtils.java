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
            BufferedImage bufferedImage = ImageIO.read(IconUtils.class.getClass().getResourceAsStream("/images/" + imageName));
            return new ImageIcon(bufferedImage.getScaledInstance(width, height, BufferedImage.SCALE_REPLICATE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
