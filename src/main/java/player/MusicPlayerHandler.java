package player;

import model.PlayList;
import model.PlayLists;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by php on 09/07/16.
 */
public class MusicPlayerHandler implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        MusicPlayer.States states = (MusicPlayer.States) o;
        if (states.equals(MusicPlayer.States.STOPPED)) {
            PlayLists.getInstance().getCurrentPlayList().playNext();
        }
    }
}
