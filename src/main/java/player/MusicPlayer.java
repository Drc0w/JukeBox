package player;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

import java.io.InputStream;

/**
 * Created by php on 07/07/16.
 */
public class MusicPlayer {
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

    public void pause() {
        synchronized (this.lock) {
            if (isRunning()) {
                this.currentStates = States.PAUSED;
            }
        }
    }

    public void resume() {
        synchronized (this.lock) {
            if (isPaused()) {
                this.currentStates = States.RUNNING;
                this.lock.notifyAll();
            }
        }
    }

    public void stop() {
        synchronized (this.lock) {
            this.currentStates = States.STOPPED;
            this.lock.notifyAll();
        }
    }

    public void close() {
        synchronized (this.lock) {
            this.currentStates = States.STOPPED;
        }
        try {
            this.player.close();
        } catch (Exception ignored) {

        }
    }

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
    private enum States {
        NOT_STARTED,
        RUNNING,
        PAUSED,
        STOPPED
    }
}
