package model;

import java.util.ArrayList;

/**
 * Created by php on 09/07/16.
 */
public class PlayLists extends Model {

    /**
     * The running PlayLists singleton
     */
    private static final PlayLists PLAYLISTS = new PlayLists();

    /**
     * The list of the PlayList
     */
    private ArrayList<PlayList> playLists;

    /**
     * The index of the current playlist playing
     */
    private int currentPlaylist;

    /**
     * Default constructor of the class
     */
    private PlayLists() {
        this.playLists = new ArrayList<>();
    }

    /**
     * Gets the running instance of the class
     *
     * @return Returns the running singleton
     */
    public static PlayLists getInstance() {
        return PLAYLISTS;
    }

    /**
     * Access to the current playlist
     *
     * @return Returns the current playlist, null if empty
     */
    public PlayList getPlayList(int pos) {
        if (pos >= 0 && pos < this.playLists.size()) {
            return this.playLists.get(pos);
        } else {
            return null;
        }
    }

    /**
     * Accessor on the current playlist's index
     *
     * @return Returns the index of the current playlist
     */
    public int getCurrentIndex() {
        return this.currentPlaylist;
    }

    /**
     * Update the index of the current plyalist
     *
     * @param pos The new position
     */
    public void setCurrentPlaylist(int pos) {
        this.currentPlaylist = pos;
    }

    /**
     * Accessor on the current playlist
     *
     * @return Returns the current playlist
     */
    public PlayList getCurrentPlayList() {
        if (this.currentPlaylist >= 0 && this.currentPlaylist < this.playLists.size()) {
            return this.playLists.get(this.currentPlaylist);
        } else {
            return null;
        }
    }

    /**
     * Remove a playlist
     *
     * @param position The position of the playlist to remove
     */
    public void removePlayList(int position) {
        this.playLists.remove(position);
    }

    /**
     * Add a playlist
     *
     * @param playList The playlist to add
     */
    public void addPlayList(PlayList playList) {
        this.playLists.add(playList);
    }

    /**
     * Notifies observers after update
     *
     * @param o Object used in order to update the model
     */
    @Override
    public void performAction(Object o) {
        this.setChanged();
        this.notifyObservers();
    }
}
