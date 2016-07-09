package model;

import java.util.ArrayList;

/**
 * Created by php on 09/07/16.
 */
public class PlayLists extends Model {
    private static final PlayLists PLAYLISTS = new PlayLists();

    private ArrayList<PlayList> playLists;

    private int currentPlaylist;

    private PlayLists() {
        this.playLists = new ArrayList<>();
        this.playLists.add(new PlayList("P1"));
        this.currentPlaylist = 0;
    }

    public static PlayLists getInstance() {
        return PLAYLISTS;
    }

    public PlayList getCurrentPlayList() {
        return this.playLists.get(this.currentPlaylist);
    }

    public void removePlayList(int position) {
        this.playLists.remove(position);
    }

    public void addPlayList(PlayList playList) {
        this.playLists.add(playList);
    }

    @Override
    public void performAction(Object o) {
        notifyObservers();
    }
}
