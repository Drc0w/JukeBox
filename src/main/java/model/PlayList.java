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

    private int currentSong;

    public PlayList(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.currentSong = 0;
    }

    public void playNext() {
        this.currentSong += 1;
        MusicPlayerService.getInstance().stop();
        if (this.currentSong >= 0 && this.currentSong < this.songs.size()) {
            try {
                MusicPlayerService.getInstance().playSong(this.songs.get(this.currentSong).getPath());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }

    public void playPrevious() {
        this.currentSong -= 1;
        MusicPlayerService.getInstance().stop();
        if (this.currentSong >= 0 && this.currentSong < this.songs.size()) {
            try {
                MusicPlayerService.getInstance().playSong(this.songs.get(this.currentSong).getPath());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }

    public void launchPlayList() {
        if (this.currentSong >= 0 && this.currentSong < this.songs.size()) {
            try {
                MusicPlayerService.getInstance().playSong(this.songs.get(this.currentSong).getPath());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    @Override
    public void performAction(Object o) {
        notifyObservers();
    }
}
