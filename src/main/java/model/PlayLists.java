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
        this.currentPlaylist = 0;
    }

    public static PlayLists getInstance() {
        return PLAYLISTS;
    }

    public PlayList getCurrentPlayList() {
        if (this.currentPlaylist >= 0 && this.currentPlaylist < this.playLists.size()) {
            return this.playLists.get(this.currentPlaylist);
        } else {
            return null;
        }
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
