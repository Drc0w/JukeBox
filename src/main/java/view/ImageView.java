package view;

import utils.IconUtils;
import utils.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class ImageView extends JPanel implements Observer {

    /**
     * References a JScrollPane that will be used in order to scroll on image
     */
    private JScrollPane scrollPane;

    /**
     * References the ImagePanel that is shown in the view
     */
    private ImagePanel imagePanel;

    /**
     * Default constructor of the class
     */
    public ImageView() {
        super();
        try {
            this.imagePanel = new ImagePanel(IconUtils.getBufferedImage("icon.png"));
            this.imagePanel.setPreferredSize(new Dimension(this.imagePanel.getWidth(), this.imagePanel.getHeight()));
            this.scrollPane = new JScrollPane(this.imagePanel);
        } catch (IOException e) {
            this.scrollPane = new JScrollPane();
            e.printStackTrace();
        }
        this.setLayout(new BorderLayout());

        this.scrollPane.setPreferredSize(new Dimension(650, 600));
        this.add(this.scrollPane, BorderLayout.CENTER);
    }

    /**
     * This function is called when observable changes
     *
     * @param observable The observable that notifies the class
     * @param o          The data that will be used in order to update the class
     */
    @Override
    public void update(Observable observable, Object o) {
        this.remove(this.scrollPane);
        this.imagePanel = (ImagePanel) o;
        this.imagePanel.setPreferredSize(new Dimension(this.imagePanel.getWidth(), this.imagePanel.getHeight()));
        this.scrollPane = new JScrollPane(this.scrollPane);

        this.repaint();
        this.revalidate();
    }
}
