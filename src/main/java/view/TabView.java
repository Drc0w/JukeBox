package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class TabView extends JPanel implements Observer {

    /**
     * The JSplitPane that is used in order to separate the ImageView and the PlayListView vertically
     */
    private JSplitPane splitPane;

    /**
     * The ImageView that corresponds to the current album illustration
     */
    private ImageView imageView;

    /**
     * The PlayListView that contains the names of the songs in the corresponding playlist
     */
    private PlayListView listView;

    /**
     * Default constructor of the class
     *
     * @param imageView    The ImageView that will be set
     * @param playListView The PlayListView that will be set
     */
    public TabView(ImageView imageView, PlayListView playListView) {
        super();
        this.setLayout(new BorderLayout());

        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        this.splitPane.setOneTouchExpandable(true);

        this.imageView = imageView;
        this.listView = playListView;

        this.splitPane.setLeftComponent(this.imageView);
        this.splitPane.setRightComponent(this.listView);
        this.add(this.splitPane, BorderLayout.CENTER);
    }

    /**
     * This function is not used at the moment.
     * This function is called when one of the object that is observed changed.
     *
     * @param observable The observable that changed
     * @param o          The object that is used in order to update
     */
    @Override
    public void update(Observable observable, Object o) {

    }
}
