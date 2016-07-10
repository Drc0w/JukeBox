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

    /**
     * Singleton design pattern on the JukeBoxPanel
     */
    private static JukeBoxPanel jukeBoxPanel = new JukeBoxPanel();

    /**
     * Represents the main panel of the user interface
     */
    private JPanel mainPanel;

    /**
     * Default constructor of the class
     */
    private JukeBoxPanel() {
        this.mainPanel = makePanel();
    }

    /**
     * Accessor on the singleton class
     *
     * @return Returns the running JukeBoxPanel
     */
    public static JukeBoxPanel getJukeBoxPanel() {
        return jukeBoxPanel;
    }

    /**
     * This function builds the panel at the bottom that contains all the buttons
     *
     * @return Returns the bottom panel
     */
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

    /**
     * This function builds the panel at the top that contains the menu
     *
     * @return Returns the top panel
     */
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

        JMenu playlist = new JMenu("Playlist");
        menuBar.add(playlist);

        JMenuItem addPlayList = new JMenuItem("New playlist");
        addPlayList.addActionListener(new AddTabController());
        playlist.add(addPlayList);

        JMenuItem removePlayList = new JMenuItem("Remove current playlist");
        removePlayList.addActionListener(new DeleteTabController());
        playlist.add(removePlayList);

        return panel;
    }

    /**
     * This function builds the other panels and store them into the main panel
     *
     * @return Returns the main panel
     */
    private JPanel makePanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(makeBottomPanel(), BorderLayout.SOUTH);
        mainPanel.add(makeTopPanel(), BorderLayout.NORTH);
        mainPanel.add(TabsView.getTabsView(), BorderLayout.CENTER);

        mainPanel.setPreferredSize(new Dimension(800, 600));
        return mainPanel;
    }

    /**
     * This function will probably never be used.
     * It updates the JukeBoxPanel when observables change
     *
     * @param observable The observable that changed
     * @param o          The object that will be used in order to update panel
     */
    @Override
    public void update(Observable observable, Object o) {

    }

    /**
     * Accessor on the main panel
     *
     * @return Returns the main panel attribute
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
