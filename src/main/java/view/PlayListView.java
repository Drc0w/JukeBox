package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class PlayListView extends JPanel implements Observer {
    private JList jList;

    private DefaultListModel<String> listModel;

    private JScrollPane scrollPane;

    public PlayListView() {
        this.listModel = new DefaultListModel<>();
        this.setLayout(new BorderLayout());

        this.jList = new JList<>(this.listModel);
        this.jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jList.setPreferredSize(new Dimension(200, 600));

        this.scrollPane = new JScrollPane(this.jList);

        this.add(this.scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
