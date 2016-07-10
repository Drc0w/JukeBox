package player;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

import java.io.InputStream;
import java.util.Observable;

/**
 * Created by php on 07/07/16.
 */
public class MusicPlayer extends Observable {
    /**
     * Object used as a lock
     * This object is used in order to lock access to other functions when modifying the current state
     */
    private final Object lock = new Object();

    /**
     * Current state of the player
     */
    private States currentStates;

    /**
     * The player on which the MusicPlayer is based
     */
    private Player player;

    /**
     * Default constructor of the MusicPlayer
     */
    public MusicPlayer(InputStream inputStream) throws JavaLayerException {
        this.currentStates = States.NOT_STARTED;
        this.player = new Player(inputStream);
    }

    /**
     * Alternate constructor of the class
     *
     * @param inputStream The stream from which music is played
     * @param audioDevice The AudioDevice that will be used by the player
     * @throws JavaLayerException Can throw exception when initializing the player
     */
    public MusicPlayer(InputStream inputStream, AudioDevice audioDevice) throws JavaLayerException {
        this.currentStates = States.NOT_STARTED;
        this.player = new Player(inputStream, audioDevice);
    }

    /**
     * This function tells if the player has started playing
     *
     * @return Returns true if the current state of the player is not set to NOT_STARTED
     */
    public boolean isStarted() {
        return this.currentStates != States.NOT_STARTED;
    }

    /**
     * This function returns true if the current state was set to RUNNING
     *
     * @return Returns true if the current state was set to RUNNING
     */
    public boolean isRunning() {
        return this.currentStates == States.RUNNING;
    }

    /**
     * This function returns true if the current state was set to PAUSED
     *
     * @return Returns true if the current state was set to PAUSED
     */
    public boolean isPaused() {
        return this.currentStates == States.PAUSED;
    }

    /**
     * This function returns true if the current state was set to PAUSED
     *
     * @return Returns true if the current state was set to PAUSED
     */
    public boolean isStopped() {
        return this.currentStates == States.STOPPED;
    }

    public void play() {
        synchronized (this.lock) {
            if (!this.isStarted()) {
                Runnable runnable = this::playInternal;
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                thread.setPriority(Thread.MAX_PRIORITY);
                this.currentStates = States.RUNNING;
                thread.start();
            } else if (this.isPaused()) {
                this.resume();
            }
        }
    }

    /**
     * This function pauses the current song
     */
    public void pause() {
        synchronized (this.lock) {
            if (isRunning()) {
                this.currentStates = States.PAUSED;
            }
        }
    }

    /**
     * This function resumes the current song
     */
    public void resume() {
        synchronized (this.lock) {
            if (isPaused()) {
                this.currentStates = States.RUNNING;
                this.lock.notifyAll();
            }
        }
    }

    /**
     * This function stops the palyer
     */
    public void stop() {
        synchronized (this.lock) {
            this.currentStates = States.STOPPED;
            this.lock.notifyAll();
        }
    }

    /**
     * This function closes the stream
     */
    public void close() {
        synchronized (this.lock) {
            this.currentStates = States.STOPPED;
        }
        try {
            this.player.close();
        } catch (Exception ignored) {

        }
        this.setChanged();
        this.notifyObservers(this.currentStates);
    }

    /**
     * This function is used in order to paly music in a separate thread
     */
    private void playInternal() {
        while (!this.isStopped()) {
            try {
                if (!this.player.play(1))
                    break;
            } catch (JavaLayerException e) {
                e.printStackTrace();
                break;
            }
            synchronized (this.lock) {
                while (this.isPaused()) {
                    try {
                        this.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }
        this.close();
    }

    /**
     * This enum is used in order to set the current state of the player
     */
    protected enum States {
        NOT_STARTED,
        RUNNING,
        PAUSED,
        STOPPED
    }
}
