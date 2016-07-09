package utils;

import java.io.File;

/**
 * Created by php on 09/07/16.
 */
public class Song {
    /**
     * The path to the file
     */
    private String path;

    /**
     * The file corresponding to the path.
     * Null if the file does not exist.
     */
    private File file;

    /**
     * Default constructor of the class
     *
     * @param filename The path to the file that will be loaded
     */
    public Song(String filename) {
        this.path = filename;
        this.file = new File(filename);
    }

    public Song(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    /**
     * Accessor on the path
     *
     * @return Returns the path to the song
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Accessor on the file
     *
     * @return Returns the file corresponding to the path
     */
    public File getFile() {
        return this.file;
    }
}
