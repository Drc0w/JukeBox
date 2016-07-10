package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by php on 09/07/16.
 */
public class ImagePanel extends JPanel {

    /**
     * BufferedImage attribute
     */
    private BufferedImage image;

    /**
     * Default constructor of the class
     *
     * @param image The buffered image to store
     */
    public ImagePanel(BufferedImage image) {
        this.image = image;
    }

    /**
     * Alternate constructor. This function creates the BufferedImage from the given file
     *
     * @param file The file to open
     */
    public ImagePanel(File file) {
        try {
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function returns the width of the image
     *
     * @return Returns the width of the component
     */
    @Override
    public int getWidth() {
        return this.image.getWidth();
    }

    /**
     * This function returns the height of the component
     *
     * @return Returns the height of the image
     */
    @Override
    public int getHeight() {
        return this.image.getHeight();
    }

    /**
     * This function paints the component
     *
     * @param graphics The graphics that will be used in order to paint component
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.image, 0, 0, null);
    }

    /**
     * Accessor on the buffered image
     *
     * @return Returns the BufferedImage attribute
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * Setter on the buffered image
     *
     * @param image The new BufferedImage
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
