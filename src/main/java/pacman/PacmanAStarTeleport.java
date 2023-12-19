package pacman;

import java.util.*;

public class PacmanAStarTeleport implements Pacman {
   private PriorityQueue<Position> toVisit;
   private HashMap<Position, Integer> cout;
   private Position finale;

   public PacmanAStarTeleport(PacmanState initial) {
      this.cout = new HashMap<Position, Integer>();
      cout.put(initial.findPacman(), 0);
      this.finale = initial.findFoods().get(0);
      this.toVisit = new PriorityQueue<Position>((s1, s2) -> Integer.compare(cout.get(s1) + s1.dist(finale), cout.get(s2) + s2.dist(finale)));
   }
   
   public Position chooseAction(PacmanState state) {
      ArrayList<Position> moves = state.findPossibleMoves();
      Iterator<Position> iter = moves.iterator();

      while (iter.hasNext()) {
         Position newPos = iter.next();
         if (!(cout.containsKey(newPos) || (toVisit.contains(newPos) && (cout.get(state.findPacman())+1 <= cout.get(newPos))))) {
            cout.put(newPos, state.findPacman().dist(newPos));
            if (!toVisit.contains(newPos)) {
                toVisit.add(newPos);
            }
         }
      }

      Position next = toVisit.peek();
      toVisit.remove(next);
      return next;
   }
}

