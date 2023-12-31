package pacman;

import java.util.*;

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
        Position pacduplicate = new Position(4, 7);
        ArrayList<Position> alreadyVisited = new ArrayList<Position>();
        alreadyVisited.add(pacman);
        System.out.println(alreadyVisited.contains(pacduplicate));
        PacmanState state = new PacmanState(board, pacman, 0, alreadyVisited);
        PacmanAStarTeleport pacmanAStar = new PacmanAStarTeleport(state);

        PacmanSimulator simulate = new PacmanSimulator(state, pacmanAStar, 50);
        simulate.gameLoop();
    }
}
