package controller;

import javazoom.jl.decoder.JavaLayerException;
import main.MainView;
import service.MusicPlayerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by php on 08/07/16.
 */
public class OpenFileController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser dialog = new JFileChooser();
        dialog.showOpenDialog(MainView.getFrame());

        if (dialog.getSelectedFile() != null) {
            try {
                MusicPlayerService.getInstance().initializeSong(dialog.getSelectedFile());
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }
}
