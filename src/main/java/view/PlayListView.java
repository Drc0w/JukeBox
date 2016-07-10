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

    /**
     * The JList containing all the songs' name
     */
    private JList<String> jList;

    /**
     * The DefaultListModel that is used in order to store the elements of the JList
     */
    private DefaultListModel<String> listModel;

    /**
     * The JScrollPane that is used in order to scroll in the JList
     */
    private JScrollPane scrollPane;

    /**
     * Default constructor of the class
     */
    public PlayListView() {
        this.listModel = new DefaultListModel<>();
        this.setLayout(new BorderLayout());

        this.jList = new JList<>(this.listModel);
        this.jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jList.setPreferredSize(new Dimension(100, 100));

        this.scrollPane = new JScrollPane(this.jList);

        this.add(this.scrollPane, BorderLayout.CENTER);
    }


    /**
     * This function is called when one of the observed object has changed
     *
     * @param observable The observable that changed
     * @param o          The object that will be used in order to update
     */
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
