package view;

import utils.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class PlayListView extends JPanel implements Observer {
    private JList<String> jList;

    private DefaultListModel<String> listModel;

    private JScrollPane scrollPane;

    public PlayListView() {
        this.listModel = new DefaultListModel<>();
        this.setLayout(new BorderLayout());

        this.jList = new JList<>(this.listModel);
        this.jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jList.setPreferredSize(new Dimension(100, 100));

        this.scrollPane = new JScrollPane(this.jList);

        this.add(this.scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {
        ArrayList<Song> songs = (ArrayList<Song>) o;

        this.remove(this.scrollPane);

        this.listModel = new DefaultListModel<>();
        for (Song song : songs) {
            this.listModel.addElement(song.getFile().getName());
        }
        this.jList = new JList<>(this.listModel);
        this.scrollPane = new JScrollPane(this.jList);
        this.add(this.scrollPane);
        
        this.repaint();
        this.revalidate();
    }
}
