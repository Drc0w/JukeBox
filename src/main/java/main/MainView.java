package main;

import view.JukeBoxPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by php on 05/07/16.
 */
public class MainView {
    /**
     * The main frame in the whole project.
     */
    private static final JFrame frame = new JFrame();

    /**
     * An accessor on the main frame
     *
     * @return Returns the main frame
     */
    public static JFrame getFrame() {
        return frame;
    }

    /**
     * Entry point of the program
     *
     * @param args Args given to the program. Not used.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame.setTitle("JukeBox");
            frame.setPreferredSize(new Dimension(800, 600));
            frame.add(JukeBoxPanel.getJukeBoxPanel().getMainPanel());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
        });

    }
}
