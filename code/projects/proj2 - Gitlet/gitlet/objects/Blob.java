package gitlet.objects;

import java.io.File;

/**
 * Blob object
 * Represents the saved contents of files
 * A single file can correspond to multiple blobs, each tracked by diff commit
 */
public class Blob {
    /**
     *
     */
    private String filePath;

    /**
     * (Transient) objects
     */
    private transient File file;

    public Blob() {
    }

}
