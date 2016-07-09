package view;

import controller.*;
import utils.IconUtils;

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

    private JComponent makeBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        JButton playButton = new JButton();
        playButton.addActionListener(new PlayController());
        playButton.setPreferredSize(new Dimension(40, 40));
        playButton.setIcon(IconUtils.getImage("play_pause.png", 40, 40));
        bottomPanel.add(playButton);

        JButton stopButton = new JButton();
        stopButton.addActionListener(new StopController());
        stopButton.setPreferredSize(new Dimension(40, 40));
        stopButton.setIcon(IconUtils.getImage("stop.png", 40, 40));
        bottomPanel.add(stopButton);

        JButton previousButton = new JButton();
        previousButton.addActionListener(new PreviousController());
        previousButton.setPreferredSize(new Dimension(40, 40));
        previousButton.setIcon(IconUtils.getImage("previous.png", 40, 40));
        bottomPanel.add(previousButton);

        JButton nextButton = new JButton();
        nextButton.addActionListener(new NextController());
        nextButton.setPreferredSize(new Dimension(40, 40));
        nextButton.setIcon(IconUtils.getImage("next.png", 40, 40));
        bottomPanel.add(nextButton);

        JButton shuffleButton = new JButton();
        shuffleButton.addActionListener(new ShuffleController());
        shuffleButton.setPreferredSize(new Dimension(40, 40));
        shuffleButton.setIcon(IconUtils.getImage("shuffle.png", 40, 40));
        bottomPanel.add(shuffleButton);

        JButton repeatButton = new JButton();
        repeatButton.addActionListener(new RepeatController());
        repeatButton.setPreferredSize(new Dimension(40, 40));
        repeatButton.setIcon(IconUtils.getImage("repeat.png", 40, 40));
        bottomPanel.add(repeatButton);

        JSlider soundSlider = new JSlider(SwingConstants.VERTICAL, 0, 100, 90);
        bottomPanel.setPreferredSize(new Dimension(800, 50));
        bottomPanel.add(soundSlider);

        return bottomPanel;
    }

    private JComponent makeTopPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        panel.add(menuBar);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        JMenuItem openFile = new JMenuItem("Open file");
        openFile.addActionListener(new OpenFileController());
        file.add(openFile);

        return panel;
    }

    private JPanel makePanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(makeBottomPanel(), BorderLayout.SOUTH);
        mainPanel.add(makeTopPanel(), BorderLayout.NORTH);
        mainPanel.add(TabsView.getTabsView(), BorderLayout.CENTER);

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
