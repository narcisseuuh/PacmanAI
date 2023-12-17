package pacman;

import java.util.*;

public class PacmanDFSTeleport implements Pacman {
   private Stack<Position> stack;
   private HashSet<Position> hs;

   public PacmanDFSTeleport() {
      this.stack = new Stack<Position>();
      this.hs = new HashSet<Position>();
   }
   
   public Position chooseAction(PacmanState state) {
      ArrayList<Position> moves = state.findPossibleMoves();
      Iterator<Position> iter = moves.iterator(); 

      while (iter.hasNext()) {
         Position newPos = iter.next();
         if (!hs.contains(newPos)) {
            hs.add(newPos);
            stack.push(newPos);
         }
      }

      return stack.pop();
   }
}
