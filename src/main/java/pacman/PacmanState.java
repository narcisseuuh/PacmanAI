/// class representing a state in the world of Pacman.
/// we consider a state is constituted of Pacman's position and the content of each box.
package pacman;

import java.util.*;

public class PacmanState {
    char[][] board;
    Position pacmanPosition;
    int score = 0;

    public PacmanState(char[][] board, Position pacmanPosition, int score) {
        this.board = board;
        this.pacmanPosition = pacmanPosition;
        this.score = score;
    }

    public PacmanState(String board, Position pacmanPosition, int score) {
        this.pacmanPosition = pacmanPosition;
        String[] lines = board.split("\n");
        this.board = new char[lines.length][lines[0].length()];
        for (int i = 0 ; i < lines.length ; i++) {
            for (int j = 0 ; j < lines[0].length() ; j++) {
                this.board[i][j] = lines[i].charAt(j);
            }
        }
        this.score = score;
    }
    
    public int getWidth() {
        return board[0].length;
    }

    public int getHeight() {
        return board.length;
    }

    public int getScore() {
        return score;
    }

    public char get(Position position) {
        int row = position.getRow();
        int col = position.getCol();

        return board[row][col];
    }

    public void set(Position position, char value) {
        int row = position.getRow();
        int col = position.getCol();

        board[row][col] = value;
    }

    public String toString() {
        String state = "";
        for (int row = 0 ; row < this.getHeight() ; row++) {
            for (int col = 0 ; col < this.getWidth() ; col++) {
                state = state + String.valueOf(this.get(new Position(row, col)));
            }
            state = state + "\n";
        }
        return state;
    }

    public Position findPacman() {
        return this.pacmanPosition;
    }
    
    public ArrayList<Position> findFoods() {
        ArrayList<Position> foods = new ArrayList<Position>();
        for (int row = 0 ; row < this.getHeight() ; row++) {
            for (int col = 0 ; col < this.getWidth() ; col++) {
                if (this.get(new Position(row, col)) == '.') foods.add(new Position(row, col));
            }
        }
        return foods;
    }

    public ArrayList findPossibleMoves() {
        ArrayList moves = new ArrayList<Position>();
        Position left = new Position(pacmanPosition.getRow(), pacmanPosition.getCol() - 1);
        if (this.get(left) == ' ') moves.add(left);
        Position right = new Position(pacmanPosition.getRow(), pacmanPosition.getCol() + 1);
        if (this.get(right) == ' ') moves.add(right);
        Position upper = new Position(pacmanPosition.getRow() + 1, pacmanPosition.getCol());
        if (this.get(upper) == ' ') moves.add(upper);
        Position lower = new Position(pacmanPosition.getRow() - 1, pacmanPosition.getCol());
        if (this.get(lower) == ' ') moves.add(lower);
        return moves;
    }

    public char[][] copyBoard() {
        return this.board.clone();
    }

    public PacmanState move(Position to) {
        PacmanState newboard = new PacmanState(this.copyBoard(), to, score + 1);

        newboard.set(this.pacmanPosition, 'V');
        newboard.set(to, 'P');
        

        return newboard;
    }

    public boolean isFinalState() {
        return this.findFoods().isEmpty();
    }

    public boolean statesEquality(PacmanState position) {
        return this.pacmanPosition.equals(position.pacmanPosition) && Objects.deepEquals(this.board, position.board);
    }
}
