package controller;

import model.PlayLists;
import player.MusicPlayerService;
import view.TabsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by php on 10/07/16.
 */
public class DeleteTabController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (TabsView.getTabsView().getTabCount() != 0) {
            int pos = TabsView.getTabsView().getSelectedIndex();
            if (pos == PlayLists.getInstance().getCurrentIndex()) {
                MusicPlayerService.getInstance().stop();
            }
            TabsView.getTabsView().remove(pos);
            PlayLists.getInstance().removePlayList(pos);
        }
    }
}