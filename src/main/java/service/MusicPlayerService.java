package service;

import javazoom.jl.decoder.JavaLayerException;
import player.MusicPlayer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by php on 08/07/16.
 */
public class MusicPlayerService {
    /**
     * Singleton desing pattern implementation on the service
     */
    private static final MusicPlayerService MUSIC_PLAYER_SERVICE = new MusicPlayerService();

    /**
     * The MusicPlayer that is used in order to play music
     */
    private MusicPlayer player;

    /**
     * Default constructor of the class
     */
    private MusicPlayerService() {

    }

    /**
     * Access the service and its method
     *
     * @return Returns the current service that is running
     */
    public static MusicPlayerService getInstance() {
        return MUSIC_PLAYER_SERVICE;
    }

    /**
     * Initialize the player with the path to the file
     *
     * @param filename The path to the file that will be played
     * @throws FileNotFoundException Can throw this exception if a bad file is given
     * @throws JavaLayerException    Can throw this exception when error occurs while initializing the player
     */
    public void initializeSong(String filename) throws FileNotFoundException, JavaLayerException {
        File file = new File(filename);
        initializeSong(file);
    }

    /**
     * Initialize the player with a file
     *
     * @param file The file that will be played
     * @throws FileNotFoundException Can throw this exception if a bad file is given
     * @throws JavaLayerException    Can throw this exception when error occurs while initializing the player
     */
    public void initializeSong(File file) throws FileNotFoundException, JavaLayerException {
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        this.player = new MusicPlayer(bufferedInputStream);
    }

    /**
     * Plays the given song. This will start playing automatically
     *
     * @param filename The file to play
     * @throws FileNotFoundException Can throw this exception if a bad file is given
     * @throws JavaLayerException    Can throw this exception while initializing the player
     */
    public void playSong(String filename) throws FileNotFoundException, JavaLayerException {
        initializeSong(filename);
        this.play();
    }

    /**
     * This function pauses the player
     */
    public void pause() {
        if (this.player != null && this.player.isRunning()) {
            this.player.pause();
        }
    }

    /**
     * This function starts playing or resumes music
     */
    public void play() {
        if (this.player != null && !this.player.isRunning()) {
            if (this.player.isPaused()) {
                this.player.resume();
            } else {
                this.player.play();
            }
        }
    }

    /**
     * This function stops the player
     */
    public void stop() {
        if (this.player != null && !this.player.isStopped()) {
            this.player.stop();
            this.player = null;
        }
    }

    /**
     * This function is used in order to know if the player is currently running
     *
     * @return Returns the state of the player
     */
    public boolean isRunning() {
        return this.player != null && this.player.isRunning();
    }

    /**
     * This function is used in order to know if the player is currently paused
     *
     * @return Returns the state of the player
     */
    public boolean isPaused() {
        return this.player != null && this.player.isPaused();
    }

    /**
     * This function is used in order to know if the player is stopped
     *
     * @return Returns the state of the player
     */
    public boolean isStopped() {
        return this.player == null || this.player.isStopped();
    }

    /**
     * This function is used in order to know if the player is currently started
     * This function must better be used in order to know if the player has not been started already, but has been initialized
     * This function might not be useful
     *
     * @return Returns the state of the player
     */
    public boolean isStarted() {
        return this.player != null && this.player.isStarted();
    }
}
