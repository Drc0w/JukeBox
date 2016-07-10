package controller;

import main.MainView;
import model.PlayLists;
import utils.Song;
import view.TabsView;

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
            if (TabsView.getTabsView().getTabCount() == 0) {
                AddTabController tabController = new AddTabController();
                tabController.actionPerformed(actionEvent);
            }
            Song song = new Song(dialog.getSelectedFile());
            PlayLists.getInstance().getPlayList(TabsView.getTabsView().getSelectedIndex()).addSong(song);
        }
    }
}
