package controller;

import main.MainView;
import model.PlayList;
import model.PlayLists;
import model.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by php on 08/07/16.
 */
public class OpenFileController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser dialog = new JFileChooser();
        dialog.showOpenDialog(MainView.getFrame());

        if (dialog.getSelectedFile() != null) {
            Song song = new Song(dialog.getSelectedFile());
            PlayList playList = new PlayList("P1");
            playList.addSong(song);
            PlayLists.getInstance().addPlayList(playList);
        }
    }
}
