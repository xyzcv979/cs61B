package gitlet.objects;

import java.io.Serializable;

import static gitlet.Constants.INITIAL_BRANCH;

/**
 * Represents a Commit tree branch
 * Each tree node is a commit
 * A node can branch off to many branches, so keep track of the children
 */
public class Branch implements Serializable {
    private Commit headPtr;
    private Commit latestPtr;
    private String name;

    // Initial branch
    public Branch() {
        name = INITIAL_BRANCH;
        headPtr = new Commit();
        latestPtr = headPtr;
    }

    public Branch(String name, Commit headPtr) {
        this.name = name;
        this.headPtr = headPtr;
        latestPtr = this.headPtr;
    }
}
