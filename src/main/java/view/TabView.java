package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class TabView extends JPanel implements Observer {

    private JSplitPane splitPane;

    private ImageView imageView;

    private PlayListView listView;

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

    @Override
    public void update(Observable observable, Object o) {

    }
}
