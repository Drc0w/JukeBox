package view;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 06/07/16.
 */
public class JukeBoxPanel implements Observer {
    private static JukeBoxPanel jukeBoxPanel = new JukeBoxPanel();

    private JPanel mainPanel;

    private JukeBoxPanel() {
        this.mainPanel = makePanel();
    }

    public static JukeBoxPanel getJukeBoxPanel() {
        return jukeBoxPanel;
    }

    private JPanel makeBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout());

        JButton playButton = new JButton();
        playButton.addActionListener(new PlayController());
        playButton.setPreferredSize(new Dimension(40, 40));
        
        bottomPanel.add(playButton);

        JButton stopButton = new JButton();
        stopButton.addActionListener(new StopController());
        stopButton.setPreferredSize(new Dimension(40, 40));
        bottomPanel.add(stopButton);

        JButton previousButton = new JButton();
        previousButton.addActionListener(new PreviousController());
        previousButton.setPreferredSize(new Dimension(40, 40));
        bottomPanel.add(previousButton);

        JButton nextButton = new JButton();
        nextButton.addActionListener(new NextController());
        nextButton.setPreferredSize(new Dimension(40, 40));
        bottomPanel.add(nextButton);

        JButton shuffleButton = new JButton();
        shuffleButton.addActionListener(new ShuffleController());
        shuffleButton.setPreferredSize(new Dimension(40, 40));
        bottomPanel.add(shuffleButton);

        JButton repeatButton = new JButton();
        repeatButton.addActionListener(new RepeatController());
        repeatButton.setPreferredSize(new Dimension(40, 40));
        bottomPanel.add(repeatButton);

        JSlider soundSlider = new JSlider(SwingConstants.VERTICAL, 0, 100, 90);
        bottomPanel.setPreferredSize(new Dimension(800, 50));
        bottomPanel.add(soundSlider);

        return bottomPanel;
    }

    private JPanel makePanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(makeBottomPanel(), BorderLayout.SOUTH);

        mainPanel.setPreferredSize(new Dimension(800, 600));
        return mainPanel;
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
