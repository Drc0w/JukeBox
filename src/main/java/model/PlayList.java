package model;

import javazoom.jl.decoder.JavaLayerException;
import player.MusicPlayerService;
import utils.Song;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by php on 09/07/16.
 */
public class PlayList extends Model {

    /**
     * Represents the name of the playlist
     */
    private String name;

    /**
     * Contains the songs in the playlist
     */
    private ArrayList<Song> songs;

    /**
     * The index of the current song
     */
    private int currentSong;

    /**
     * Default constructor of the class
     *
     * @param name The name of the playlist
     */
    public PlayList(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.currentSong = 0;
    }

    /**
     * This function will play the next song
     * It will stop if the current song is the last song
     */
    public void playNext() {
        if (this.currentSong >= 0 && this.currentSong < this.songs.size() - 1) {
            this.currentSong += 1;
            try {
                MusicPlayerService.getInstance().playSong(this.songs.get(this.currentSong).getPath());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This function will play the previous song
     * It will restart the current song if it is the first song of the playlist
     */
    public void playPrevious() {
        if (this.currentSong >= 0 && this.currentSong < this.songs.size()) {
            this.currentSong = this.currentSong > 0 ? this.currentSong - 1 : 0;
            try {
                MusicPlayerService.getInstance().playSong(this.songs.get(this.currentSong).getPath());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        } else if (this.currentSong < 0) {
            this.currentSong = 0;
        }
    }

    /**
     * This function will start playing the playlist
     */
    public void launchPlayList() {
        if (this.currentSong >= 0 && this.currentSong < this.songs.size()) {
            try {
                MusicPlayerService.getInstance().playSong(this.songs.get(this.currentSong).getPath());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This function will add a song the playlist
     * Observers will be notified because of the changes
     *
     * @param song The song to add to the playlist
     */
    public void addSong(Song song) {
        this.songs.add(song);
        this.setChanged();
        this.notifyObservers(this.songs);
    }


    /**
     * Will notify observers after changes
     *
     * @param o Object used in order to update the model
     */
    @Override
    public void performAction(Object o) {
        setChanged();
        notifyObservers(songs);
    }
}
