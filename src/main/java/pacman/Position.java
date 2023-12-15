/// containing a point described by coordinates row and col.
package pacman;

import java.lang.*;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public boolean equals(Position pos) {
        return this.row == pos.getRow() && this.col == pos.getCol();
    }

    public int hashCode() {
        return Integer.hashCode(row) * 31 + Integer.hashCode(col);
    }

    public String toString() {
        return "(" + this.row + "," + this.col + ")"; 
    }

    public int dist(Position pos) {
        return Math.abs(this.row - pos.row) + Math.abs(this.col - pos.col);
    }
}
