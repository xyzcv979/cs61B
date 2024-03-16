package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;
    /** True iff game is ended. */
    private boolean gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /** Return the current score. */
    public int score() {
        return score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

        // TODO 4: Modify this.board (and perhaps this.score) to account
        // for the tilt to the Side SIDE. If the board changed, set the
        // changed local variable to true.

        /**
         * Focus on UP direction
         * starting from top row down
         * first tile is moved all the way up
         * conditions:
         *  1. Only 1 tile
         *      1.1 if tile not at top square, move it
         *  2. 2 tiles
         *      2.1 same value
         *      2.2 diff value
         *  3. 3 tiles
         *      3.1 top 2 are same values
         *      3.2 bottom 2 are same values
         *      3.3 all different values
         *  4. 4 tiles
         *      4.1 top 2 are same
         *      4.2 mid 2 are same
         *      4.3 bottom 2 are same
         *      4.4 all diff values
         *
         *
         * for every column
         * for every row
         * move number square to top most valid square. Either combine or move to one below or it stays in position
         * */
        board.setViewingPerspective(side);
        int sz = board.size();
        for (int i = 0; i < sz; i++) {
            if (processColumnForTilt(i)) {
                changed = true;
            }
        }

        checkGameOver();
        if (changed) {
            setChanged();
        }
        board.setViewingPerspective(Side.NORTH);
        return changed;
    }

    private boolean processColumnForTilt(int col) {
        int sz = board.size();
        boolean changed = false;
        int topAvailSpot = sz-1; // top square in column
        for (int row = sz-1; row >= 0; row--) {
//            Tile t = board.tile(i, j);
//            if (t != null) {
//                board.move(i, 1, t);
//                changed = true;
//                score += 7;
//            }
            int result = processSquare(col, row, topAvailSpot);
            if (result == -1) { // empty current tile
                continue;
            }
            topAvailSpot = result;
            changed = true;
        }
        return changed;
    }

    private int processSquare(int col, int row, int topAvailSpot) {
        if (topAvailSpot == row) {
            return -1;
        }
        Tile topTile = board.tile(col, topAvailSpot);
        Tile currTile = board.tile(col, row);
        if (currTile == null) {
            return -1;
        }
        if (topTile == null) {
            board.move(col, topAvailSpot, currTile); // still valid for merging
        }
        else if (topTile.value() == currTile.value()) {
            // same values, so merge them into 1 square
            score += (currTile.value()*2);
            board.move(col, topAvailSpot, currTile);
            topAvailSpot--; // marks as no longer valid for merging

        } else {
            // move to next avail spot. (1 before topAvailSpot)
            // or stays in position
            // This becomes new topAvailSpot
            topAvailSpot--; // Since the values aren't the same, this square goes to one below.
            if (row != topAvailSpot) { // only move if topAvailSpot is different from current spot
                board.move(col, topAvailSpot, currTile);
            }
        }
        return topAvailSpot;
    }



    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public static boolean emptySpaceExists(Board b) {
        // TODO 1: Fill in this function.
        int sz = b.size();
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (b.tile(i,j) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        // TODO 2: Fill in this function.
        int sz = b.size();
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (b.tile(i,j) != null && b.tile(i,j).value() == MAX_PIECE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO 3: Fill in this function.
        if (emptySpaceExists(b) || sameValueAdjacentTiles(b)) {
            return true;
        }
        return false;
    }

    /**
     * atLeastOneMoveExists helper function
     * Returns true if 2 adjacent tiles have the same value
     * */
    private static boolean sameValueAdjacentTiles(Board b) {
        int sz = b.size();
        for (int i = 1; i < sz; i++) {
            for (int j = 1; j < sz; j++) {
                // Check on same row
                if (b.tile(i,j) != null && b.tile(i-1, j) != null && b.tile(i,j).value() == b.tile(i-1,j).value()) {
                    return true;
                }
                // Check on same column
                if (b.tile(i,j) != null && b.tile(i, j-1) != null && b.tile(i,j).value() == b.tile(i,j-1).value()) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}
