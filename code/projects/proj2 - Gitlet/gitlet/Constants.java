package gitlet;

import java.util.Date;

public final class Constants {
    private Constants() {

    }
    public static final String INITIAL_BRANCH = "main";
    public static final String INITIAL_COMMIT_MSG = "initial commit";
    public static final Date INITIAL_DATE = new Date(0);
    public static final String GITLET_DIR_NAME = ".gitlet";
    public static final String BRANCH_DIR_NAME = "Branch";
}
