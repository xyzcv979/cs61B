package gitlet.objects;

// TODO: any imports you need here

import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class
import java.util.TreeMap;

import static gitlet.Constants.INITIAL_COMMIT_MSG;
import static gitlet.Constants.INITIAL_DATE;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    private String message;
    private Date timestamp;
    // Mapping of file name to blob references
    // The blob reference should be the SHA hash
    TreeMap<String, String> fileToBlobMap;
    // SHA Hash of commit for the parent
    private String parentId;
    // Second parent reference for merges
    private String secParent;

    public Commit() {
        this(INITIAL_COMMIT_MSG, INITIAL_DATE);
    }

    public Commit(String msg, Date timestamp) {
        message = msg;
        this.timestamp = timestamp;
        //blobList = new ArrayList<Blob>();
        parentId = null;
        secParent = null;
        fileToBlobMap = new TreeMap<>();
    }

}
