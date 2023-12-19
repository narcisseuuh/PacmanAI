package pacman;

import java.util.*;

public class PacmanAStar implements Pacman {
   private ArrayList<Position> finales;
   private PriorityQueue<Position> toVisit;

   PacmanAStar(PacmanState initial) {
      this.finales = initial.findFoods();
      this.toVisit = new PriorityQueue<PacmanState>((s1,s2) -> Integer.compare(this.calculateHeuristic(s1), this.calculateHeuristic(s2)));
   }

   public int calculateHeuristic(PacmanState state) {
      return state.findFoods().size();
   }
   
   public Position chooseAction(PacmanState state) {
      
   }
}
