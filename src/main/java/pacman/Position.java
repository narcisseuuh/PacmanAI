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
    
    @Override
    public boolean equals(Object object) {
        boolean same = false;
        if (object != null && object instanceof Position) {
            same = this.row == ((Position) object).getRow() && this.col == ((Position) object).getCol();
        }
        return same;
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
