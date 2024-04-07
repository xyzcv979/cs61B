package gitlet;

import gitlet.objects.Branch;
import gitlet.objects.Commit;

import java.io.File;

import static gitlet.util.Constants.*;
import static gitlet.util.Utils.*;

/** Represents a gitlet repository.
 *  Every repository is a Commit Tree which references many branches.
 *  Each branch is a differ pointer in the Commit Tree
 *  The Commit Tree is made up of many commits
 *
 *  @author Me :D
 */
public class Repository {
    /** The current working directory. */
    // public static final File CWD = new File(System.getProperty("user.dir"));
    public static final File CWD = join(new File(System.getProperty("user.dir")), WORKING_DIR);;

    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, GITLET_DIR_NAME);
    /** The list of branches. Each branch is a pointer to a commit on the Commit Tree */
    public static Commit[] branches;

    /** Initialize a Gitlet repository with .gitlet dir, main branch, empty commit, and empty blob dir */
    public static void init() {
        if (CWD.exists() || GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);
        }

        CWD.mkdir();
        GITLET_DIR.mkdir();

        // TODO: Create main branch, and first commit and serialize the branch onto a file
        try {
            // Commits
            File commitDir = join(GITLET_DIR, COMMIT_DIR_NAME);
            commitDir.mkdir();
            // TODO: Create first commit

            // Branches
            File branchDir = join(GITLET_DIR, BRANCH_DIR_NAME);
            branchDir.mkdir();
            // TODO: Create first branch
//            Branch mainBranch = new Branch(INITIAL_BRANCH, firstCommit);
//            writeObject(join(branchDir, INITIAL_BRANCH), mainBranch);

            // Blobs
            File blobDir = join(GITLET_DIR, BLOB_DIR_NAME);
            blobDir.mkdir();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            GITLET_DIR.delete();
            CWD.delete();
            System.exit(0);
        }
    }

    /**
     * Adds a copy of the file to staging area.
     * Staging an already staged file overwrites the previous entry.
     * If current working file is identical to same file in current commit, do not stage,
     * and remove from staging area if it's already there
     * (This happens when file is changed, added, changed back to orig version
     */
    public static void add(String fileName) {
        File file = join(CWD, fileName);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(0);
        }

        // Create blob? hash the file
        // Do i need to store TreeMap as a file too? Saves file name to blob hash reference

        // 1. New file, not in commit
        // hash it, upload as blob, save to TreeMap the filename and hash object, save to staging area

        // 2. Modified file, file in commit already
        // hash it, upload as blob, add to TreeMap?, save to staging area

        // 3. File has no change from previous commit's version
        //
    }
}
