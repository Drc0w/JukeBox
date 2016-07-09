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
        if (this.currentSong >= 0 && this.currentSong < this.songs.size() - 1) {
            this.currentSong += 1;
            try {
                MusicPlayerService.getInstance().playSong(this.songs.get(this.currentSong).getPath());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }

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
        this.setChanged();
        this.notifyObservers(this.songs);
    }

    @Override
    public void performAction(Object o) {
        setChanged();
        notifyObservers(songs);
    }
}
