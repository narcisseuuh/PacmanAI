package pacman;

import java.util.*;

public class PacmanAStarTeleport implements Pacman {
   private PriorityQueue<Position> toVisit;
   private HashMap<Position, Integer> cout;

   public PacmanAStarTeleport(PacmanState initial) {
      this.cout = new HashMap<Position, Integer>();
      cout.put(initial.findPacman(), 0);
      this.toVisit = new PriorityQueue<Position>((s1, s2) -> Integer.compare(cout.get(s1), cout.get(s2)));
   }
   
   public Position chooseAction(PacmanState state) {
      ArrayList<Position> moves = state.findPossibleMoves();
      Iterator<Position> iter = moves.iterator(); 

      while (iter.hasNext()) {
         Position newPos = iter.next();
         if (!cout.containsKey(newPos)) {
            cout.put(newPos, state.findPacman().dist(newPos));
            toVisit.add(newPos);
         } else {
            cout.replace(newPos, cout.get(newPos) + state.findPacman().dist(newPos));
            toVisit.add(newPos);
         }
      }

      Position next = toVisit.peek();
      toVisit.remove(next);
      return next;
   }
}

