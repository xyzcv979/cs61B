package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    private void checkOperands() {
        // If a user inputs a command with the wrong number or format of operands,
        // print the message Incorrect operands. and exit.
    }

    private void checkGitletDir() {
        // If a user inputs a command that requires being in an initialized Gitlet working directory
        // (i.e., one containing a .gitlet subdirectory), but is not in such a directory,
        // print the message Not in an initialized Gitlet directory.
    }

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a command.");
            System.exit(0);
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                Repository.init();
                break;
            case "add":
                break;
            case "commit":
                break;
            case "rm":
                break;
            case "log":
                break;
            case "global-log":
                break;
            case "find":
                break;
            case "status":
                break;
            case "checkout":
                break;
            case "branch":
                break;
            case "rm-branch":
                break;
            case "reset":
                break;
            case "merge":
                break;
            default:
                System.out.println("No command with that name exists.");
        }
    }
}
