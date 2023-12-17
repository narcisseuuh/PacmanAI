package pacman;


public class Main {
    public static void main(String[] args) {
        String board = """
            ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉
            ▉                                          ▉
            ▉ ▉▉▉▉ ▉▉▉▉▉▉▉▉▉▉▉          ▉▉▉▉▉▉▉▉▉▉     ▉
            ▉ ▉ ▉   ▉▉ ▉▉▉▉▉▉▉▉▉         ▉▉▉▉▉▉▉▉▉▉▉ ▉▉▉
            ▉   ▉▉▉P▉▉           ▉▉▉▉▉▉▉             ▉▉▉
            ▉▉▉▉▉▉▉▉▉▉▉▉▉▉ ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉ ▉▉▉▉▉▉▉▉
            ▉            ▉ ▉      ▉    ▉  ▉  ▉  ▉      ▉
            ▉ ▉▉▉▉▉▉▉▉▉▉ ▉ ▉▉▉▉▉▉ ▉  ▉▉▉▉▉▉▉▉▉  ▉ ▉ ▉  ▉
            ▉ ▉ ▉      ▉ ▉                        ▉ ▉  ▉
            ▉ ▉ ▉ ▉▉▉▉▉▉ ▉ ▉▉▉▉▉▉ ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉
            ▉ ▉ ▉ ▉    ▉ ▉ ▉      ▉         ▉       ▉  ▉
            ▉ ▉ ▉ ▉  ▉ ▉   ▉  ▉   ▉     ▉▉  ▉▉      ▉  ▉
            ▉ ▉ ▉ ▉  ▉ ▉ ▉▉▉  ▉     ▉▉▉▉▉▉ ▉▉▉▉▉▉   ▉  ▉
            ▉   ▉ ▉  ▉   ▉    ▉   ▉                   .▉
            ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉
            """;

        Position pacman = new Position(7, 4);
        PacmanState state = new PacmanState(board, pacman, 0);
        PacmanDFSTeleport pacmanDFS = new PacmanDFSTeleport();

        PacmanSimulator simulate = new PacmanSimulator(state, pacmanDFS, 5);
        simulate.gameLoop();
    }
}
