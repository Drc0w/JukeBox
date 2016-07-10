package player;

import model.PlayLists;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class MusicPlayerHandler implements Observer {
    /**
     * This function will be called as the player changes its current state
     *
     * @param observable The currently playing player
     * @param o          The current state of the player after its update
     */
    @Override
    public void update(Observable observable, Object o) {
        MusicPlayer.States states = (MusicPlayer.States) o;
        if (states.equals(MusicPlayer.States.STOPPED)) {
            PlayLists.getInstance().getCurrentPlayList().playNext();
        }
    }
}
