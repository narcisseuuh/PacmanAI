package pacman;

import java.util.*;

public class PacmanBFSTeleport implements Pacman {
   private ArrayDeque<Position> queue;
   private HashSet<Position> hs;

   public PacmanBFSTeleport() {
      this.queue = new ArrayDeque<Position>();
      this.hs = new HashSet<Position>();
   }
   
   public Position chooseAction(PacmanState state) {
      ArrayList<Position> moves = state.findPossibleMoves();
      Iterator<Position> iter = moves.iterator(); 

      while (iter.hasNext()) {
         Position newPos = iter.next();
         if (!hs.contains(newPos)) {
            hs.add(newPos);
            queue.add(newPos);
         }
      }


      return queue.remove();
   }
}
