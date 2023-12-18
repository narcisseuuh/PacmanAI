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

        Position pacman = new Position(4, 7);
        PacmanState state = new PacmanState(board, pacman, 0);
        PacmanAStarTeleport pacmanAStar = new PacmanAStarTeleport(state);

        PacmanSimulator simulate = new PacmanSimulator(state, pacmanAStar, 50);
        simulate.gameLoop();
    }
}
