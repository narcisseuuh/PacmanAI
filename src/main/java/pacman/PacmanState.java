/// class representing a state in the world of Pacman.
/// we consider a state is constituted of Pacman's position and the content of each box.
package pacman;

public class PacmanState {
    char[][] board;
    Position pacmanPosition;

    public PacmanState(char[][] board, Position pacmanPosition) {
        this.board = board;
        this.pacmanPosition = pacmanPosition;
    }

    public PacmanState(String board, Position pacmanPosition) {
        this.pacmanPosition = pacmanPosition;
        String[] lines = board.split("\n");
        for (int i = 0 ; i < lines[0].length() ; i++) {
            for (int j = 0 ; j < lines.length ; j++) {
                this.board[i][j] = lines[i].charAt(j);
            }
        }
    }
    
    public int getWidth() {
        return board[0].length;
    }

    public int getHeight() {
        return board.length;
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

    public String getState() {
        String state = "";
        for (int i = 0 ; i < this.getWidth() ; i++) {
            for (int j = 0 ; j < this.getHeight() ; j++) {
                state = state + String.valueOf(this.get(new Position(i, j)));
            }
            state = state + "\n";
        }
        return state;
    }
}
