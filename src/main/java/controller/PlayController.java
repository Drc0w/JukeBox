package controller;

import model.PlayLists;
import player.MusicPlayerService;
import view.TabsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by php on 06/07/16.
 */
public class PlayController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (PlayLists.getInstance().getCurrentIndex() != TabsView.getTabsView().getSelectedIndex()) {
            PlayLists.getInstance().setCurrentPlaylist(TabsView.getTabsView().getSelectedIndex());
            PlayLists.getInstance().getCurrentPlayList().launchPlayList();
        } else if (!MusicPlayerService.getInstance().isStarted()) {
            PlayLists.getInstance().getCurrentPlayList().launchPlayList();
        } else if (!MusicPlayerService.getInstance().isRunning()) {
            MusicPlayerService.getInstance().play();
        } else {
            MusicPlayerService.getInstance().pause();
        }
    }
}
