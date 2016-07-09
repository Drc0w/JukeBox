package controller;

import main.MainView;
import model.PlayList;
import model.PlayLists;
import view.ImageView;
import view.PlayListView;
import view.TabView;
import view.TabsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by php on 10/07/16.
 */
public class AddTabController implements ActionListener {

    private static int tabId = 0;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String message = JOptionPane.showInputDialog(MainView.getFrame(), "Name the playlist");

        if (message != null && message.equals("")) {
            message = String.format("PlayList %d", tabId);
            tabId++;
        } else if (message == null) {
            return;
        }

        PlayListView playListView = new PlayListView();
        PlayList playList = new PlayList(message);
        playList.addObserver(playListView);

        TabView tabView = new TabView(new ImageView(), playListView);

        PlayLists.getInstance().addPlayList(playList);
        TabsView.getTabsView().addTab(message, tabView);
    }
}
