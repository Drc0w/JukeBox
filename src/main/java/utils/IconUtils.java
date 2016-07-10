package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by php on 07/07/16.
 */
public class IconUtils {

    /**
     * Creates a new ImageIcon. Image will be scaled.
     *
     * @param imageName The name of the image to open
     * @param width     The desired width of the image
     * @param height    The desired height of the image
     * @return Returns a scaled instance of the opened image
     */
    public static ImageIcon getImage(String imageName, int width, int height) {
        try {
            return new ImageIcon(getBufferedImage(imageName).getScaledInstance(width, height, BufferedImage.SCALE_REPLICATE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Opens an image
     *
     * @param imageName The image to open
     * @return Returns the image that has the given name
     */
    public static ImageIcon getImage(String imageName) {
        try {
            return new ImageIcon(getBufferedImage(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a buffered image
     *
     * @param imageName The image to open
     * @return Returns the buffered image that corresponds to the given image
     * @throws IOException Can throw IOException when reading file
     */
    public static BufferedImage getBufferedImage(String imageName) throws IOException {
        return ImageIO.read(IconUtils.class.getClass().getResourceAsStream("/images/" + imageName));
    }
}
