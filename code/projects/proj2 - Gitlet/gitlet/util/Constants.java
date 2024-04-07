package gitlet.util;

import java.util.Date;

public final class Constants {
    private Constants() {

    }
    public static final String INITIAL_BRANCH = "main";
    public static final String INITIAL_COMMIT_MSG = "initial commit";
    public static final Date INITIAL_DATE = new Date(0);
    public static final String GITLET_DIR_NAME = ".gitlet";
    public static final String BRANCH_DIR_NAME = "Branches";
    public static final String COMMIT_DIR_NAME = "Commits";
    public static final String BLOB_DIR_NAME = "Blobs";
    public static final String WORKING_DIR = "working_dir";
}
