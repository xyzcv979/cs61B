package gitlet.objects;

// TODO: any imports you need here

import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class
import java.util.TreeMap;


/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    private String message;
    private Date timestamp;

    // SHA Hash of commit for the parent
    private String parentId;
    // Second parent reference for merges
    private String secParent;

    /** (Transient) Redundant pointers to Commit objects for runtime operations
     * State is not saved when serialized onto a file. Returns as Null when deserialized
     * */
    private transient Commit parentCopy;
    // Mapping of file name to blob references
    // The blob reference should be the SHA hash
    private transient TreeMap<String, Blob> fileToBlobMap;


    public Commit() {

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
