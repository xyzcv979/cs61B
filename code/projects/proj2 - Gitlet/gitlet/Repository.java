package gitlet;

import gitlet.objects.Branch;
import gitlet.objects.Commit;

import java.io.File;

import static gitlet.Constants.*;
import static gitlet.Utils.*;

/** Represents a gitlet repository.
 *  Every repository is a Commit Tree which references many branches.
 *  Each branch is a differ pointer in the Commit Tree
 *  The Commit Tree is made up of many commits
 *
 *  @author Me :D
 */
public class Repository {
    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, GITLET_DIR_NAME);
    /** The list of branches. Each branch is a pointer to a commit on the Commit Tree */
    public static Commit[] branches;

    /** Initialize a Gitlet repository with .gitlet dir, main branch, empty commit, and empty blob dir */
    public static void init() {
        if (GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);
        }
        boolean mkdirResult = GITLET_DIR.mkdir();
        if (!mkdirResult) {
            System.out.println("Gitlet failed to create Gitlet directory");
            System.exit(0);
        }

        // TODO: Create main branch, and first commit and serialize the branch onto a file
        try {
            Branch mainBranch = new Branch();
            File branchDir = join(GITLET_DIR, BRANCH_DIR_NAME);
            mkdirResult = branchDir.mkdir();
            if (!mkdirResult) {
                System.out.println("Gitlet failed to create Branch directory");
                System.exit(0);
            }
            writeObject(join(branchDir, INITIAL_BRANCH), mainBranch);

        } catch(Exception e) {
            System.out.println(e.getMessage());
            GITLET_DIR.delete();
            System.exit(0);
        }

    }
}
