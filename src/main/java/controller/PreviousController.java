package controller;

import model.PlayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by php on 06/07/16.
 */
public class PreviousController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (PlayLists.getInstance().getCurrentPlayList() != null) {
            PlayLists.getInstance().getCurrentPlayList().playPrevious();
        }
    }
}
