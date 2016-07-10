package controller;

import player.MusicPlayerService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by php on 06/07/16.
 */
public class StopController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MusicPlayerService.getInstance().stop();
    }
}
